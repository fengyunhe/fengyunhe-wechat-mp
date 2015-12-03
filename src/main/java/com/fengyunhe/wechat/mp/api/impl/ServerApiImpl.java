package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.ServerApi;
import com.fengyunhe.wechat.mp.api.bean.ServerAccessToken;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class ServerApiImpl implements ServerApi {


    protected final WeChatApp app;
    private static Map<String, ServerAccessToken> token = new HashMap<String, ServerAccessToken>();

    public ServerApiImpl(WeChatApp app) {
        this.app = app;
    }

    public static final String GET_SERVER_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
    public static final String GET_SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    public static final String GET_QR_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";


    @Override
    public List<String> getServerIpList() {

        try {
            String jsonStr = HttpClientHelper.INSTANCE.get(GET_SERVER_IP_URL + getAccessToken().getAccess_token());
            JsonNode jsonNode = ErrorCode.check(jsonStr);
            if (jsonNode.has("ip_list")) {
                List<String> ipList = new ArrayList<String>();
                Iterator<JsonNode> ip_list = jsonNode.get("ip_list").iterator();
                while (ip_list.hasNext()) {
                    ipList.add(ip_list.next().asText());
                }
                return ipList;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取access_token
     *
     * @return
     * @throws Exception
     */
    public ServerAccessToken getAccessToken() {
        if (token == null
                || token.get(app.getAppId()) == null || token.get(app.getAppId()).getExpireOnTime() < System.currentTimeMillis() - 5000) {
            synchronized (app.getAppId()) {
                String jsonStr = null;
                try {
                    jsonStr = HttpClientHelper.INSTANCE.get(GET_ACCESS_TOKEN_URL.concat("&appid=")
                            + app.getAppId() + "&secret=" + app.getAppSecret());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ErrorCode.check(jsonStr);

                ServerAccessToken t = JsonObjectUtils
                        .jsonToBean(jsonStr, ServerAccessToken.class);
                t.setAuthOnTime(System.currentTimeMillis());
                t.setExpireOnTime(System.currentTimeMillis()
                        + t.getExpires_in() * 1000);
                token.put(app.getAppId(), t);
            }
        }
        return token.get(app.getAppId());
    }

    @Override
    public String getAccessTokenString() {
        return this.getAccessToken().getAccess_token();
    }


    @Override
    public String getTempQrcodeTicket(String accessToken, long sceneId) {
        String url = GET_QR_TICKET_URL + accessToken;
        // {"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info":
        // {"scene": {"scene_id": 123}}}
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("expire_seconds", 1800);
        params.put("action_name", "QR_SCENE");

        Map<String, Object> action_info = new HashMap<String, Object>();
        Map<String, Object> scene = new HashMap<String, Object>();
        scene.put("scene_id", sceneId);
        action_info.put("scene", scene);
        params.put("action_info", action_info);
        String post = JsonObjectUtils.beanToJson(params);

        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(url, post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // {"ticket":"gQG28DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0FuWC1DNmZuVEhvMVp4NDNMRnNRAAIEesLvUQMECAcAAA==","expire_seconds":1800}
        JsonNode json = ErrorCode.check(result);
        ;
        if (json.has("ticket")) {
            return json.get("ticket").getTextValue();
        }
        return null;
    }

    @Override
    public String getQrcodeTicket(String accessToken, int sceneId) {
        String url = GET_QR_TICKET_URL + accessToken;
        // {"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info":
        // {"scene": {"scene_id": 123}}}
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action_name", "QR_LIMIT_SCENE");

        Map<String, Object> action_info = new HashMap<String, Object>();
        Map<String, Object> scene = new HashMap<String, Object>();
        scene.put("scene_id", sceneId);
        action_info.put("scene", scene);
        params.put("action_info", action_info);
        String post = JsonObjectUtils.beanToJson(params);

        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(url, post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // {"ticket":"gQG28DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0FuWC1DNmZuVEhvMVp4NDNMRnNRAAIEesLvUQMECAcAAA==","expire_seconds":1800}

        JsonNode json = ErrorCode.check(result);
        ;
        if (json.has("ticket")) {
            return json.get("ticket").getTextValue();
        }
        return null;
    }

    @Override
    public String getQrcodeTicket(String accessToken, String sceneStr) {
        String url = GET_QR_TICKET_URL + accessToken;
        // {"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info":
        // {"scene": {"scene_id": 123}}}
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action_name", "QR_LIMIT_SCENE");

        Map<String, Object> action_info = new HashMap<String, Object>();
        Map<String, Object> scene = new HashMap<String, Object>();
        scene.put("scene_str", sceneStr);
        action_info.put("scene", scene);
        params.put("action_info", action_info);
        String post = JsonObjectUtils.beanToJson(params);

        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(url, post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // {"ticket":"gQG28DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0FuWC1DNmZuVEhvMVp4NDNMRnNRAAIEesLvUQMECAcAAA==","expire_seconds":1800}

        JsonNode json = ErrorCode.check(result);
        ;
        if (json.has("ticket")) {
            return json.get("ticket").getTextValue();
        }
        return null;
    }

    @Override
    public String getQrcodeUrl(String ticket) {
        try {
            return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="
                    + URLEncoder.encode(ticket, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getShortUrl(String accessToken, String longUrl) {
        String url = GET_SHORT_URL + accessToken;
        // {"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info":
        // {"scene": {"scene_id": 123}}}
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", "long2short");
        params.put("long_url", longUrl);
        String post = JsonObjectUtils.beanToJson(params);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(url, post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode json = ErrorCode.check(result);
        ;
        if (json.has("short_url")) {
            return json.get("short_url").getTextValue();
        }
        return null;
    }
}
