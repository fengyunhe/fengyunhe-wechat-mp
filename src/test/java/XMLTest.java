import com.fengyunhe.wechat.mp.api.bean.RedPack;
import com.fengyunhe.wechat.mp.api.util.MessageUtil;
import com.fengyunhe.wechat.mp.req.msg.TextMessage;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * XML TO object, object to XML 转换test
 * Created by yangyan on 2015/6/17.
 */
public class XMLTest {
    final String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

    /**
     * 测试XML和bean相互转换
     */
    @Test
    public void testBeanToXML() {
        RedPack object = new RedPack();
        object.setAct_id("fff");
        object.setNonce_str("ff");

        String requestBody = MessageUtil.beanToXML(object);
        System.out.println(requestBody);


        TextMessage textMessage = new TextMessage();
        textMessage.setContent("dd");
        String s1 = MessageUtil.beanToXML(textMessage);
        System.out.println(s1);

    }

    @Test
    public void testMsgDecrypt() {
        String msg = "<xml>\n" +
                "    <URL><![CDATA[http://8616270.oicp.net/wechat/api.do]]></URL>\n" +
                "    <ToUserName><![CDATA[oKISRt3VahqPYguWhlAtucujH7_0]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[gh_6b8e2e8e40b7]]></FromUserName>\n" +
                "    <CreateTime>1434079746</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[123]]></Content>\n" +
                "    <MsgId>1111</MsgId>\n" +
                "    <Encrypt><![CDATA[7GT5hoon0WZxSIVwdaMsf5PMKu2EOOEHFh1C96z00Xc9l2sVm+5seJkOH/5vkrw9MZMaAVPdKGhUMRgrqg7qY+MR/vFS1g57tbUwjLXmJ48m1F/kHAUGIMhw0KqEfKgcHyM9PD5Ogs6nhYuYqSI61vuaWRD0U4GjZQ6oJWrdWL+HyH8itvMwcNfQpOCaOTAuFsSx12c1d6vGH8ZgUFsCTAmRlpEaEDye+C+JBWfc4kFW3F9EI1LCpFG7pApK0BfT18O7oQGfQb6yLo8mLIXoDe66qpehhuEBlH6QRwaRRHKXzVvGU+QS4sGhH9aa/m5SZ97PvS0j1l1aBkQHdsRQ9b7sSpXONwFhZcKce84MI7qH91njNey0+7EcaWxRBo/MnBwAqXfz1+wlFSxVLSUoN1DAuxb4BKWfk8IuRC8JJkjR35O5HYqZYHrR4o8qzh9gtincNfA5iyTz1d2vUwCV01ZqcVjG40/Q/EMpRufIAxIUbECiD2v5rayIXm2L67Ui]]></Encrypt>\n" +
                "</xml>";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(msg);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName("Encrypt");
            // NodeList nodelist2 = root.getElementsByTagName("MsgSignature");


            String encrypt = nodelist1.item(0).getTextContent();
            // String msgSignature = nodelist2.item(0).getTextContent();

            String fromXML = String.format(xmlFormat, encrypt);

            System.out.println(fromXML);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
