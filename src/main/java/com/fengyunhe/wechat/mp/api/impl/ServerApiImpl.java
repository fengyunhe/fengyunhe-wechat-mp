package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.MediaType;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.ServerApi;
import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.Attachment;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;
import com.fengyunhe.wechat.mp.api.bean.ServerAccessToken;
import com.fengyunhe.utils.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

public class ServerApiImpl implements ServerApi {


    private final WeChatApp app;
    private ServerAccessToken token;

    public ServerApiImpl(WeChatApp app) {
        this.app = app;
    }

    public static final String GET_SERVER_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
    public static final String GET_SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    public static final String GET_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=";
    public static final String UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=";
    public static final String GET_QR_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
    public static final String UPLOAD_IMG_URL = "https://file.api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";

    @Override
    public List<String> getServerIpList() {

        try {
            String jsonStr = com.fengyunhe.utils.HttpClientHelper.INSTANCE.get(GET_SERVER_IP_URL + getAccessToken().getAccess_token());
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
    public synchronized ServerAccessToken getAccessToken() {
        if (token == null
                || token.getExpireOnTime() < System.currentTimeMillis() - 5000) {
            String jsonStr = null;
            try {
                jsonStr = HttpClientHelper.INSTANCE.get(GET_ACCESS_TOKEN_URL.concat("&appid=")
                        + app.getAppId() + "&secret=" + app.getAppSecret());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ErrorCode.check(jsonStr);
            token = JsonObjectUtils
                    .jsonToBean(jsonStr, ServerAccessToken.class);
            token.setAuthOnTime(System.currentTimeMillis());
            token.setExpireOnTime(System.currentTimeMillis()
                    + token.getExpires_in() * 1000);
        }
        return token;
    }

    @Override
    public String getAccessTokenString() {
        return this.getAccessToken().getAccess_token();
    }

    /**
     * 获取媒体资源
     *
     * @param accessToken
     * @param mediaId
     * @return
     * @throws IOException
     */
    public Attachment getMedia(String accessToken, String mediaId) {
        String url = GET_MEDIA_URL + accessToken + "&media_id=" + mediaId;
        Attachment att = HttpClientHelper.INSTANCE.download(url);
        return att;
    }

    /**
     * 上传素材文件
     *
     * @param type
     * @param file
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws IOException
     */
    public MediaInfo uploadMedia(String accessToken, MediaType type, File file) {
        String url = UPLOAD_MEDIA_URL + accessToken + "&type=" + type.name();
        String jsonStr = HttpClientHelper.INSTANCE.upload(url, file);
        JsonNode jsonNode = ErrorCode.check(jsonStr);
        return JsonObjectUtils.jsonNodeToBean(jsonNode, MediaInfo.class);
    }

    @Override
    public String uploadImg(String accessToken, File file) {
        String url = UPLOAD_IMG_URL + accessToken;
        String jsonStr = HttpClientHelper.INSTANCE.upload(url, file);
        JsonNode jsonNode = ErrorCode.check(jsonStr);
        return jsonNode.has("url") ? jsonNode
                .get("url").getTextValue() : null;
    }

    @Override
    public MediaInfo uploadNews(String accessToken, List<Article> articleList) {
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + accessToken;
        Map<String, Object> params = new java.util.HashMap<String, Object>();
        params.put("articles", articleList);
        String jsonStr = null;
        try {
            jsonStr = com.fengyunhe.wechat.mp.api.util.HttpClientHelper.INSTANCE.post(url, JsonObjectUtils.beanToJson(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = JsonObjectUtils.stringToJsonNode(jsonStr);
        ErrorCode.check(jsonNode);
        return JsonObjectUtils.jsonToBean(jsonStr, MediaInfo.class);

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
