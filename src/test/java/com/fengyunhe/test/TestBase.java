package com.fengyunhe.test;

import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.WeChat;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.junit.Before;

/**
 * Created by yangyan on 2015/6/19.
 */
public class TestBase {
    protected WeChat weChat;
    protected String openId = "oKISRt3VahqPYguWhlAtucujH7_0";
    protected WeChatApp app = new WeChatApp(
            "wx06f396eca375d3a0",
            "1722a7052bc48f96a96cccd22136d666",
            "yangyan",
            "gh_4ce15ace69ac"
    );

    @Before
    public void setUp() throws Exception {
        weChat = new WeChat(app);
    }

    protected void out(Object o) {
        System.out.println(JsonObjectUtils.beanToJson(o));
    }

    protected String token() {
        return weChat.getServerApi().getAccessToken().getAccess_token();
    }
}
