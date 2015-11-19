package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.ServerJsApiTicket;

import java.util.Map;

/**
 *
 */
public interface JsApi {
    /**
     * jsapi_ticket是公众号用于调用微信JS接口的临时票据。
     * 正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。
     * 由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket 。
     * <p/>
     * 通过access_token获取jsapi_ticket
     *
     * @param accessToken
     * @return
     */
    public ServerJsApiTicket getJsapi_ticket(String accessToken);

    /**
     * 签名算法
     * <p/>
     * 签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。
     * 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * 这里需要注意的是所有参数名均为小写字符。对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。
     * 步骤1. 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * 步骤2. 对string1进行sha1签名，得到signature。
     * <p/>
     * 注意事项
     * <p/>
     * 签名用的noncestr和timestamp必须与wx.config中的nonceStr和timestamp相同。
     * 签名用的url必须是调用JS接口页面的完整URL。
     * 出于安全考虑，开发者必须在服务器端实现签名的逻辑。
     *
     * @param jsapi_ticket
     * @param urlStr
     * @return
     */
    public Map<String, Object> sign(String jsapi_ticket, String urlStr);
}
