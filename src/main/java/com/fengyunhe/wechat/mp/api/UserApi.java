package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.Follwers;
import com.fengyunhe.wechat.mp.api.bean.OAuthWxUser;
import com.fengyunhe.wechat.mp.api.bean.User;
import com.fengyunhe.wechat.mp.api.bean.UserAccessToken;

import java.util.List;

/**
 * 用户相关API
 */
public interface UserApi {

    /**
     * 获取用户的基本信息
     *
     * @param accessToken
     * @param openid
     * @return
     * @
     */
    User getUserInfo(String accessToken, String openid);

    /**
     * 批量获取用户的基本信息,每次最多传入100个id
     *
     * @param accessToken
     * @param openid
     * @return
     */
    List<User> getUsersInfo(String accessToken, String... openid);

    /**
     * 获取网页授权用户的信息
     *
     * @param accessToken
     * @param openid
     * @return
     */
    OAuthWxUser getUserInfoWithOAuthToken(String accessToken, String openid);

    /**
     * 返回粉丝列表
     *
     * @param accessToken
     * @param next_openid
     * @return
     * @
     */
    Follwers getFollwersList(String accessToken, String next_openid)
    ;

    /**
     * 返回基本网页授权URL
     *
     * @param state
     * @return
     */
    String getAuthorizationBaseUrl(String redirectUrl, String state);

    /**
     * 返回可获得用户信息网页授权URL
     *
     * @param state
     * @return
     */
    String getAuthorizationUserInfoUrl(String redirectUrl, String state);

    /**
     * 返回网页授权URL
     *
     * @param scope
     * @param state
     * @return
     */
    String getAuthorizationUrl(String scope, String redirectUrl, String state);

    /**
     * 使用授权后获得的code换取微信用户的accessToken
     *
     * @param code
     * @return
     * @
     */
    UserAccessToken getAccessToken(String code);

    /**
     * 使用刷新token刷新用户的 accessToken，并返回新的accessToken
     *
     * @param refreshToken
     * @return
     * @
     */
    UserAccessToken getRefreshToken(String refreshToken);

    /**
     * 设置用户备注
     *
     * @param accessToken
     * @param openId
     * @param remark
     * @return
     */
    public boolean setUserRemark(String accessToken, String openId, String remark);

}
