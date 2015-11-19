import org.junit.Test;

/**
 * 功能：
 * 作者： yangyan
 * 时间： 2015/6/24 .
 */
public class QrTest extends BaseTest {

    @Test
    public void testGetQrTick() {
        String test = weChat.getServerApi().getQrcodeTicket(weChat.getServerApi().getAccessToken().getAccess_token(), "test");
        System.out.println(test);
        String qrcodeUrl = weChat.getServerApi().getQrcodeUrl(test);
        System.out.println(qrcodeUrl);
    }
}
