package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.MassApi;
import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.google.common.collect.ImmutableMap;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：群发消息
 * 作者： yangyan
 * 时间： 2014/8/16 .
 */
public class MassApiImpl extends ServerApiImpl implements MassApi {

    public static final String SEND_TO_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";
    public static final String SEND_TO_USERS_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
    public static final String DELETE_URL = "https://api.weixin.qq.com//cgi-bin/message/mass/delete?access_token=";
    public static final String PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";
    public static final String GET_STATUS_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";

    public MassApiImpl(WeChatApp app) {
        super(app);
    }


    @Override
    public MediaInfo getUploadVideoMediaId(String accessToken, String mediaId, String title, String description) {
        String url = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=" + accessToken;
        Map<String, Object> params = new java.util.HashMap<String, Object>();
        params.put("media_id", mediaId);
        params.put("title", title);
        params.put("description", description);

        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.post(url, JsonObjectUtils.beanToJson(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = JsonObjectUtils.stringToJsonNode(jsonStr);
        ErrorCode.check(jsonNode);
        return JsonObjectUtils.jsonToBean(jsonStr, MediaInfo.class);
    }

    @Override
    public String sendNewsToGroup(String accessToken, String mediaId, String groupId) {

//        {
//            "filter":{
//              "group_id":"2"
//            },
//            "mpnews":{
//                "media_id":"123dsdajkasd231jhksad"
//            },
//            "msgtype":"mpnews"
//        }

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "mpnews");
        Map<String, Object> mpnews = new HashMap<String, Object>();
        mpnews.put("media_id", mediaId);
        json.put("mpnews", mpnews);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("group_id", groupId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_GROUP_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendNewsToUsers(String accessToken, String mediaId, String... openId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "mpnews");
        Map<String, Object> mpnews = new HashMap<String, Object>();
        mpnews.put("media_id", mediaId);
        json.put("mpnews", mpnews);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", openId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_USERS_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendTextToGroup(String accessToken, String content, String groupId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "text");
        Map<String, Object> text = new HashMap<String, Object>();
        text.put("content", content);
        json.put("text", text);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("group_id", groupId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_GROUP_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendTextToUsers(String accessToken, String content, String... openId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "text");
        Map<String, Object> text = new HashMap<String, Object>();
        text.put("content", content);
        json.put("text", text);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", openId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_USERS_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendVoiceToGroup(String accessToken, String mediaId, String groupId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "voice");
        Map<String, Object> voice = new HashMap<String, Object>();
        voice.put("media_id", mediaId);
        json.put("voice", voice);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("group_id", groupId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_GROUP_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendVoiceToUsers(String accessToken, String mediaId, String... openId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "voice");
        Map<String, Object> voice = new HashMap<String, Object>();
        voice.put("media_id", mediaId);
        json.put("voice", voice);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", openId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_USERS_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendImageToGroup(String accessToken, String mediaId, String groupId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "image");
        Map<String, Object> image = new HashMap<String, Object>();
        image.put("media_id", mediaId);
        json.put("image", image);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("group_id", groupId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_GROUP_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendImageToUsers(String accessToken, String mediaId, String... openId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "image");
        Map<String, Object> image = new HashMap<String, Object>();
        image.put("media_id", mediaId);
        json.put("image", image);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", openId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_USERS_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendVideoToGroup(String accessToken, String mediaId, String title, String description, String groupId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "video");
        Map<String, Object> video = new HashMap<String, Object>();
        video.put("media_id", mediaId);
        video.put("title", title);
        video.put("description", description);
        json.put("video", video);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("group_id", groupId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_GROUP_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public String sendVideoToUsers(String accessToken, String mediaId, String title, String description, String... openId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msgtype", "video");
        Map<String, Object> video = new HashMap<String, Object>();
        video.put("media_id", mediaId);
        video.put("title", title);
        video.put("description", description);
        json.put("video", video);
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", openId);
        json.put("filter", filter);
        String post = JsonObjectUtils.beanToJson(json);
        //System.out.println(post);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(SEND_TO_USERS_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return check.get("msg_id").getTextValue();
    }

    @Override
    public boolean delete(String accessToken, String msgId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msg_id", msgId);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(DELETE_URL.concat(accessToken), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewNews(String openId, String mediaId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "mpnews");
        json.put("mpnews", ImmutableMap.of("media_id", mediaId));

//        "touser":"OPENID",
//                "mpnews":{
//            "media_id":"123dsdajkasd231jhksad"
//        },
//        "msgtype":"mpnews"


        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewText(String openId, String content) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "text");
        json.put("content", content);

//        {
//            "touser":"OPENID",
//                "text":{
//            "content":"CONTENT"
//        },
//            "msgtype":"text"
//        }


        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewVoice(String openId, String mediaId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "voice");
        json.put("voice", ImmutableMap.of("media_id", mediaId));

//       {
//           "touser":"OPENID",
//           "voice":{
//                   "media_id":"123dsdajkasd231jhksad"
//                   },
//           "msgtype":"voice"
//       }


        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewImage(String openId, String mediaId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "image");
        json.put("image", ImmutableMap.of("media_id", mediaId));

//       {
//           "touser":"OPENID",
//           "image":{
//                   "media_id":"123dsdajkasd231jhksad"
//                   },
//           "msgtype":"image"
//       }


        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewVideo(String openId, String mediaId) {


//       {
//           "touser":"OPENID",
//           "mpvideo":{
//                   "media_id":"123dsdajkasd231jhksad"
//                   },
//           "msgtype":"mpvideo"
//       }

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "mpvideo");
        json.put("mpvideo", ImmutableMap.of("media_id", mediaId));
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean previewCard(String openId, String cardId, String cardExt) {

//        { "touser":"OPENID",
//                "wxcard":{
//            "card_id":"123dsdajkasd231jhksad",
//                    "card_ext": "{\"code\":\"\",\"openid\":\"\",\"timestamp\":\"1402057159\",\"signature\":\"017bb17407c8e0058a66d72dcc61632b70f511ad\"}"
//        },
//            "msgtype":"wxcard"
//        }

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("touser", openId);
        json.put("msgtype", "wxcard");
        json.put("wxcard", ImmutableMap.of(
                "card_id", cardId,
                "card_ext", cardExt
        ));
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public boolean getMassStatus(int msgId) {
//        {
//            "msg_id":201053012,
//                "msg_status":"SEND_SUCCESS"
//        }
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("msg_id", msgId);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = HttpClientHelper.INSTANCE.post(PREVIEW_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        if (check.get("msg_status").getTextValue().equals("SEND_SUCCESS")) {
            return true;
        }
        return false;
    }
}
