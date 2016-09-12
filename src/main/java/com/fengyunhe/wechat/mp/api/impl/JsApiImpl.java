package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.JsApi;
import com.fengyunhe.wechat.mp.api.bean.ServerJsApiTicket;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.fengyunhe.wechat.mp.api.util.Tools;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JsApiImpl extends ServerApiImpl implements JsApi {
    /**
     * jsapi_ticket是公众号用于调用微信JS接口的临时票据。
     * 正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。
     * 由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket 。
     */
    private static final String JSAPI_TICKET_GET_URI = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    Log log = LogFactory.getLog(UserApiImpl.class);
    private static ServerJsApiTicket serverJsApiTicket;

    public JsApiImpl(WeChatApp app) {
        super(app);
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 通过access_token获取jsapi_ticket
     *
     * @param accessToken
     * @return
     */
    @Override
    public synchronized ServerJsApiTicket getJsapi_ticket(String accessToken) {
        if (serverJsApiTicket == null
                || serverJsApiTicket.getExpireOnTime() < System.currentTimeMillis() - 30000) {
            String jsonStr = null;

            while(jsonStr==null) {
                try {
                    jsonStr = HttpClientHelper.INSTANCE.get(JSAPI_TICKET_GET_URI.replace("ACCESS_TOKEN", accessToken));
                    JsonNode node = ErrorCode.checkJsApiTicketJson(jsonStr);
                    if (42001 == node.get("errcode").getIntValue()) {
                        accessToken = this.getAccessToken().getAccess_token();
                        jsonStr = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            serverJsApiTicket = JsonObjectUtils.jsonToBean(jsonStr, ServerJsApiTicket.class);
            serverJsApiTicket.setAuthOnTime(System.currentTimeMillis());
            serverJsApiTicket.setExpireOnTime(System.currentTimeMillis() + serverJsApiTicket.getExpires_in() * 1000);
        }
        return serverJsApiTicket;
    }

    /**
     * 签名算法
     * <p>
     * 签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。
     * 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * 这里需要注意的是所有参数名均为小写字符。对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。
     * 步骤1. 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * 步骤2. 对string1进行sha1签名，得到signature。
     * <p>
     * 注意事项
     * <p>
     * 签名用的noncestr和timestamp必须与wx.config中的nonceStr和timestamp相同。
     * 签名用的url必须是调用JS接口页面的完整URL。
     * 出于安全考虑，开发者必须在服务器端实现签名的逻辑。
     *
     * @param jsapi_ticket
     * @param urlStr
     * @return
     */
    @Override
    public Map<String, Object> sign(String jsapi_ticket, String urlStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        String string1;
        String signature = "";
        //注意这里参数名必须全部小写，且必须有序
        long timestamp = Tools.timestamp();
        String nonceStr = Tools.nonceStr();
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonceStr +
                "&timestamp=" + timestamp +
                "&url=" + urlStr;
//        signature = SHA1Util.Sha1(string1);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            log.info("jsApi签名失败!", e);
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            log.info("jsApi签名失败!", e);
            e.printStackTrace();
        }
        map.put("timestamp", timestamp);
        map.put("nonceStr", nonceStr);
        map.put("signature", signature);
        return map;
    }
}
