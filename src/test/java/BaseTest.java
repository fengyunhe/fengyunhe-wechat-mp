import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.WeChat;

/**
 * 功能：
 * 作者： yangyan
 * 时间： 2015/6/24 .
 */
public class BaseTest {


    private String appId = "wx06f396eca375d3a0";
    private String appSecret = "1722a7052bc48f96a96cccd22136d666";
    private String msgEncryptKey = "";
    private String token = "yangyan";
    private String mpId = "gh_71346cb736a2";
    protected WeChatApp app = new WeChatApp(appId, appSecret, token, mpId, msgEncryptKey);
    protected WeChat weChat = new WeChat(app);
}
