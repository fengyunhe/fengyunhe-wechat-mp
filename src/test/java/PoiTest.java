import com.fengyunhe.wechat.mp.api.bean.PoiInfo;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.junit.Test;

/**
 * Created by yangyan on 2015/6/2.
 */
public class PoiTest {

    @Test
    public void beanTest() {


        PoiInfo poiInfo = new PoiInfo(new PoiInfo.Business(new PoiInfo.Business.BaseInfo(


        )));

        System.out.println(JsonObjectUtils.beanToJson(poiInfo));
    }

    @Test
    public void jsonTest() {
        String json = JsonObjectUtils.createJson(new String[]{"poi_id"}, new Object[]{"112124"});


        System.out.println(json);

    }
}
