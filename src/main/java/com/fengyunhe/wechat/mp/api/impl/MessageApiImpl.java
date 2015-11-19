package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.MessageApi;
import com.fengyunhe.wechat.mp.api.bean.*;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

/**
 * 客服消息接口
 *
 * @author L.cm
 * @date 2013-11-5 下午3:32:30
 */
public class MessageApiImpl extends ServerApiImpl implements MessageApi {

    private static final String MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

    public MessageApiImpl(WeChatApp app) {
        super(app);
    }

    /**
     * 发送文本客服消息
     *
     * @param openId
     * @param text
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public boolean sendText(String accessToken, String openId, String text) {
        Map<String, Object> json = new HashMap<String, Object>();
        Map<String, Object> textObj = new HashMap<String, Object>();
        textObj.put("content", text);
        json.put("touser", openId);
        json.put("msgtype", "text");
        json.put("text", textObj);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    public boolean sendImage(String accessToken, String openId, Image image) {
        Map<String, Object> json = new HashMap<String, Object>();

        json.put("touser", openId);
        json.put("msgtype", "image");
        json.put("image", image);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    public boolean sendVoice(String accessToken, String openId, Voice voice) {
        Map<String, Object> json = new HashMap<String, Object>();

        json.put("touser", openId);
        json.put("msgtype", "voice");
        json.put("voice", voice);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    public boolean sendVideo(String accessToken, String openId, Video video) {
        Map<String, Object> json = new HashMap<String, Object>();

        json.put("touser", openId);
        json.put("msgtype", "video");
        json.put("video", video);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    public boolean sendMusic(String accessToken, String openId, Music music) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "music");
        json.put("music", music);
        String post = JsonObjectUtils.beanToJson(json);

//        System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    public boolean sendNews(String accessToken, String openId, News news) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "news");
        json.put("news", news);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean sendMsg(String accessToken, String json) {
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(MESSAGE_URL.concat(accessToken), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorCode.check(result);
        return true;
    }

}
