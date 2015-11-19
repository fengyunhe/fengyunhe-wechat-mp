package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.test.TestBase;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.bean.Follwers;
import com.fengyunhe.wechat.mp.api.bean.User;
import com.fengyunhe.wechat.mp.api.bean.UserAccessToken;
import com.fengyunhe.wechat.mp.api.impl.UserApiImpl;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试用户API
 * Created by yangyan on 2015/6/19.
 */
public class UserApiTest extends TestBase {


    @Test
    @Ignore
    public void testGetUserInfo() throws Exception {
        User userInfo = weChat.getUserApi().getUserInfo(token(), openId);
        out(userInfo);
    }

    @Test
    @Ignore
    public void testGetFollwersList() throws Exception {
        Follwers follwersList = weChat.getUserApi().getFollwersList(token(), null);
        out(follwersList);
    }


    @Test
    @Ignore
    public void testSetUserRemark() throws Exception {
        boolean success = weChat.getUserApi().setUserRemark(token(), openId, "杨焱");
        out(success);
    }
}