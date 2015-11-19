package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.UserApi;
import com.fengyunhe.wechat.mp.api.bean.Follwers;
import com.fengyunhe.wechat.mp.api.bean.OAuthWxUser;
import com.fengyunhe.wechat.mp.api.bean.User;
import com.fengyunhe.wechat.mp.api.bean.UserAccessToken;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

public class UserApiImpl implements UserApi {

    Log log = LogFactory.getLog(UserApiImpl.class);
    private final WeChatApp app;


    public UserApiImpl(WeChatApp app) {
        this.app = app;
    }

    private static final java.lang.String OAUTH2_USER_INFO_URI = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN";
    private static final String USER_GET_URI = "https://api.weixin.qq.com/cgi-bin/user/get";
    private static final String USER_INFO_URI = "https://api.weixin.qq.com/cgi-bin/user/info";
    public static final String BATCH_USER_INFO_URI = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
    private static final String OAUTH2_CODE_URI = "http://open.weixin.qq.com/connect/oauth2/authorize";
    private static final String OAUTH2_TOKEN_URI = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String OAUTH2_REFRESH_TOKEN_URI = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    private static final String UPDATE_USER_REMARK_URI = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";

    /**
     * 拉取用户信息
     *
     * @param accessToken
     * @param openid
     * @return
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public User getUserInfo(String accessToken, String openid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);
        params.put("openid", openid);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.get(USER_INFO_URI, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug(USER_INFO_URI + "返回：" + "\n" + jsonStr);
        if (StringUtils.isNotEmpty(jsonStr)) {
            ErrorCode.check(jsonStr);
            User user = JsonObjectUtils.jsonToBean(jsonStr, User.class);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getUsersInfo(String accessToken, String... openid) {

        if (openid == null || openid.length > 100) {
            throw new RuntimeException("传入的id太多了，最多100个哦");
        }
        Map<String, Object> params = new HashMap<String, Object>();

        List<Map<String, String>> idList = new ArrayList<Map<String, String>>();
        params.put("user_list", idList);

        if (openid != null) {
            for (String s : openid) {
                idList.add(ImmutableMap.of("openid", s, "lang", "zh-CN"));
            }
        }

        String paramsJson = JsonObjectUtils.beanToJson(params);
//        System.out.println(paramsJson);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.post(BATCH_USER_INFO_URI + accessToken, paramsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug(USER_INFO_URI + "返回：" + "\n" + jsonStr);
        if (StringUtils.isNotEmpty(jsonStr)) {
            JsonNode check = ErrorCode.check(jsonStr);

            List<User> userList = new ArrayList<User>();
            Iterator<JsonNode> user_info_list = check.get("user_info_list").iterator();

            while (user_info_list.hasNext()) {
                JsonNode next = user_info_list.next();
                User user = JsonObjectUtils.jsonNodeToBean(next, User.class);
                userList.add(user);
            }
            return userList;
        }
        return null;

    }

    @Override
    public OAuthWxUser getUserInfoWithOAuthToken(String accessToken, String openid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);
        params.put("openid", openid);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.get(OAUTH2_USER_INFO_URI, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.debug(USER_INFO_URI + "返回：" + "\n" + jsonStr);
        if (StringUtils.isNotEmpty(jsonStr)) {
            ErrorCode.check(jsonStr);
            OAuthWxUser user = JsonObjectUtils.jsonToBean(jsonStr, OAuthWxUser.class);
            return user;
        }
        return null;
    }

    /**
     * 获取帐号的关注者列表
     *
     * @param accessToken
     * @param next_openid
     * @return
     */
    public Follwers getFollwersList(String accessToken, String next_openid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);
        params.put("next_openid", next_openid);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.get(USER_GET_URI, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(jsonStr)) {
            ErrorCode.check(jsonStr);

            return JsonObjectUtils.jsonToBean(jsonStr, Follwers.class);
        }
        return null;
    }

    public String getAuthorizationBaseUrl(String redirectUrl, String state) {
        return getAuthorizationUrl("snsapi_base", redirectUrl, state);
    }

    public String getAuthorizationUserInfoUrl(String redirectUrl, String state) {
        return getAuthorizationUrl("snsapi_userinfo", redirectUrl, state);
    }

    /**
     * 请求code
     *
     * @return
     */
    public String getAuthorizationUrl(String scope, String redirectUrl, String state) {
        if (scope == null) {
            scope = "snsapi_base";
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", app.getAppId());
        params.put("response_type", "code");
        try {
            params.put("redirect_uri", URLEncoder.encode(redirectUrl, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        params.put("scope", scope); // snsapi_base（不弹出授权页面，只能拿到用户openid）snsapi_userinfo
        // （弹出授权页面，这个可以通过 openid 拿到昵称、性别、所在地）

        if (state != null) {
            try {
                state = URLEncoder.encode(state, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        params.put("state", state == null ? "none" : state + "#wechat_redirect");
        String para = createSign(params, false);
        return OAUTH2_CODE_URI + "?" + para;
    }

    /**
     * 通过code 换取 access_token
     *
     * @param code
     * @return
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public UserAccessToken getAccessToken(String code) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", app.getAppId());
        params.put("secret", app.getAppSecret());
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        String string = null;
        try {
            string = HttpClientHelper.INSTANCE.get(OAUTH2_TOKEN_URI, params);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode check = ErrorCode.check(string);

        UserAccessToken token = JsonObjectUtils.jsonToBean(string,
                UserAccessToken.class);
        token.setAuthOnTime(System.currentTimeMillis());
        token.setExpireOnTime(System.currentTimeMillis()
                + token.getExpires_in() * 1000);
        return token;
    }

    /**
     * 刷新 access_token
     *
     * @param refreshToken
     * @return
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public UserAccessToken getRefreshToken(String refreshToken) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", app.getAppId());
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", refreshToken);
        String string = null;
        try {
            string = HttpClientHelper.INSTANCE.get(OAUTH2_REFRESH_TOKEN_URI, params);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserAccessToken token = JsonObjectUtils.jsonToBean(string,
                UserAccessToken.class);
        token.setAuthOnTime(System.currentTimeMillis());
        token.setExpireOnTime(System.currentTimeMillis()
                + token.getExpires_in() * 1000);

        return token;
    }

    @Override
    public boolean setUserRemark(String accessToken, String openId, String remark) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("openid", openId);
        params.put("remark", remark);
        String jsonStr = null;
        try {
            jsonStr = HttpClientHelper.INSTANCE.post(UPDATE_USER_REMARK_URI + accessToken, JsonObjectUtils.beanToJson(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(jsonStr)) {
            ErrorCode.check(jsonStr);
            return true;
        }
        return false;
    }


    /**
     * 构造签名
     *
     * @param params
     * @param encode
     * @return
     */
    private String createSign(Map<String, String> params, boolean encode) {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = value.toString();
            }
            if (encode) {
                try {
                    temp.append(URLEncoder.encode(valueString, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                temp.append(valueString);
            }
        }
        return temp.toString();
    }

}