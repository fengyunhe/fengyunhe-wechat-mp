import com.fengyunhe.wechat.mp.api.bean.CardInfo;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by yangyan on 2015/6/2.
 */
public class CardTest {

    @Test
    @Ignore
    public void testCard() {
        CardInfo.GeneralCouponCardInfo generalCouponCardInfo = new CardInfo.GeneralCouponCardInfo(new CardInfo.GeneralCouponCard(new CardInfo.BaseInfo(), "ff"));
        System.out.println(JsonObjectUtils.beanToJson(generalCouponCardInfo));


        CardInfo.MeetingTicketInfo meetingTicketInfo = new CardInfo.MeetingTicketInfo(new CardInfo.MeetingTicket("", "", new CardInfo.BaseInfo()));
        System.out.println(JsonObjectUtils.beanToJson(meetingTicketInfo));
    }
}
