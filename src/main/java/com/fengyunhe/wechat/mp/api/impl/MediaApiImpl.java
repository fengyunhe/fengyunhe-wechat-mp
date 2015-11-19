package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.utils.HttpClientHelper;
import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.MediaType;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.MediaApi;
import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.Attachment;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.google.common.collect.ImmutableMap;
import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 27716 on 2015/11/19.
 */
public class MediaApiImpl extends ServerApiImpl implements MediaApi {

    public MediaApiImpl(WeChatApp app) {
        super(app);
    }

    private static final String ADD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
    private static final String UPDATE_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";
    public static final String GET_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=";
    public static final String UPLOAD_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";
    public static final String UPLOAD_IMG_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
    public static final String ADD_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
    public static final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
    public static final String DEL_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
    public static final String GET_MATERIAL_COUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
    /**
     * 获取媒体资源
     *
     * @param accessToken
     * @param mediaId
     * @return
     * @throws IOException
     */
    @Override
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
    @Override
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
    public String addNews(String accessToken, List<Article> articleList) {
        String url = ADD_NEWS_URL + accessToken;
        Map<String, Object> params = new java.util.HashMap<String, Object>();
        params.put("articles", articleList);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.post(url, JsonObjectUtils.beanToJson(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = JsonObjectUtils.stringToJsonNode(jsonStr);
        ErrorCode.check(jsonNode);
        if (jsonNode.has("media_id")) {
            return jsonNode.get("media_id").getTextValue();
        }
        return null;
    }

    @Override
    public boolean updateNews(String mediaId, int index, Article article) {
        String url = UPDATE_NEWS_URL + getAccessTokenString();
        Map<String, Object> params = new java.util.HashMap<String, Object>();
        params.put("articles", article);
        params.put("index", index);
        params.put("media_id", mediaId);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.post(url, JsonObjectUtils.beanToJson(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = JsonObjectUtils.stringToJsonNode(jsonStr);
        ErrorCode.check(jsonNode);
        return true;
    }

    @Override
    public String addMaterial(MediaType type, File file, String title, String introduction) {


        Map<String, String> params = new HashMap<String, String>();
        params.put("type", type.name());
        if (type.equals(MediaType.video)) {
            String pJson = JsonObjectUtils.beanToJson(ImmutableMap.of(
                    "title", title,
                    "introduction", introduction));
            params.put("description", pJson);
        }

        String json = HttpClientHelper.INSTANCE.upload(ADD_MATERIAL_URL + getAccessTokenString(), params, "media", file);
        JsonNode check = ErrorCode.check(json);

        if (check.has("media_id")) {
            if (type.equals(MediaType.image)) {
                return check.get("url").getTextValue();
            }
            return check.get("media_id").getTextValue();
        }
        return null;
    }

    @Override
    public boolean delMaterial(String mediaId) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("media_id", mediaId);
        String post = JsonObjectUtils.beanToJson(json);
        String result = null;
        try {
            result = com.fengyunhe.wechat.mp.api.util.HttpClientHelper.INSTANCE.post(DEL_MATERIAL_URL.concat(getAccessTokenString()), post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode check = ErrorCode.check(result);
        return true;
    }

    @Override
    public Map<String, Integer> getMaterialCount() {
        try {
            String s = HttpClientHelper.INSTANCE.get(GET_MATERIAL_COUNT_URL + getAccessTokenString());
            JsonNode check = ErrorCode.check(s);


            return JsonObjectUtils.jsonNodeToBean(check, HashMap.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
