package com.fengyunhe.wechat.mp.api.util;

import com.fengyunhe.wechat.mp.MsgType;
import com.fengyunhe.wechat.mp.req.UnknownRequestMessage;
import com.fengyunhe.wechat.mp.req.event.*;
import com.fengyunhe.wechat.mp.req.msg.*;
import com.fengyunhe.wechat.mp.resp.msg.NewsSyncMessage;
import com.fengyunhe.wechat.mp.EventType;
import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

public class MessageUtil {


    private MessageUtil() {
    }

    /**
     * 接收到的消息转换为消息对象
     *
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static AbstractRequestMessage requestXmlToMessage(String xml)
            throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        Class<? extends AbstractRequestMessage> msgTypeClass = null;
        String msgType = document.getRootElement()
                .selectSingleNode("//MsgType").getStringValue();

        MsgType type = MsgType.valueOf(msgType);
        switch (type) {
            case text:
                msgTypeClass = TextMessage.class;
                break;
            case image:
                msgTypeClass = ImageMessage.class;
                break;
            case link:
                msgTypeClass = LinkMessage.class;
                break;
            case location:
                msgTypeClass = LocationMessage.class;
                break;
            case video:
                msgTypeClass = VideoMessage.class;
                break;
            case voice:
                msgTypeClass = VoiceMessage.class;
                break;
            case event:
                String eventType = document.getRootElement()
                        .selectSingleNode("//Event").getStringValue();
                try {
                    EventType e = EventType.valueOf(eventType);
                    switch (e) {
                        case CLICK:
                            msgTypeClass = MenuClickEvent.class;
                            break;
                        case VIEW:
                            msgTypeClass = MenuViewClickEvent.class;
                            break;
                        case LOCATION:
                            msgTypeClass = LocationEvent.class;
                            break;
                        case SCAN:
                            msgTypeClass = ScanEvent.class;
                            break;
                        case subscribe:
                            Node selectSingleNode = document.getRootElement()
                                    .selectSingleNode("//EventKey");
                            if (selectSingleNode != null
                                    && selectSingleNode.getStringValue().startsWith(
                                    "qrscene_")) {
                                msgTypeClass = ScanSubscribeEvent.class;
                            } else {
                                msgTypeClass = SubscribeEvent.class;
                            }
                            break;
                        case unsubscribe:
                            msgTypeClass = UnsubscribeEvent.class;
                            break;
                        case MASSSENDJOBFINISH:
                            msgTypeClass = MassSendJobFinshEvent.class;
                            break;
                        case scancode_push:
                            msgTypeClass = ScanCodePushEvent.class;
                            break;
                        case scancode_waitmsg:
                            msgTypeClass = ScanCodeWaitMsgEvent.class;
                            break;
                        case pic_sysphoto:
                            msgTypeClass = PicSysphoneEvent.class;
                            break;
                        case pic_photo_or_album:
                            msgTypeClass = PicPhotoOrAlbumEvent.class;
                            break;
                        case pic_weixin:
                            msgTypeClass = PicWeixinEvent.class;
                            break;
                        case location_select:
                            msgTypeClass = LocationSelectEvent.class;
                            break;
                        default:
                            break;
                    }
                } catch (IllegalArgumentException
                        e) {
                    msgTypeClass = null;
                }
                break;
            default:
                break;
        }

        if (msgTypeClass == null) {
            return new UnknownRequestMessage(xml);
        }
        return convertXmlToBean(xml, msgTypeClass);
    }

    /**
     * 接收到的消息转换为消息对象
     *
     * @param request
     * @param clazz
     * @param <T>
     * @return
     * @throws DocumentException
     */
    public static <T> T requestXmlToMessage(HttpServletRequest request,
                                            Class<T> clazz) throws DocumentException {

        String xml = null;
        try {
            xml = IOUtils.toString(request.getInputStream(), "UTF-8");
            XStream xstream = xstream();
            xstream.alias("xml", clazz);
            return (T) xstream.fromXML(xml);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * XML消息转换为指定类型的对象
     *
     * @param xml
     * @param clazz
     * @param <T>
     * @return
     * @throws DocumentException
     */
    public static <T> T convertXmlToBean(String xml, Class<T> clazz)
            throws DocumentException {
        XStream xstream = xstream();
        xstream.alias("xml", clazz);
        return (T) xstream.fromXML(xml);
    }

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     * @throws Exception
     */
    public static AbstractRequestMessage requestXmlToMessage(
            HttpServletRequest request) throws IOException, DocumentException {
        String xml = IOUtils.toString(request.getInputStream(), "UTF-8");
        return requestXmlToMessage(xml);
    }

    /**
     * 响应消息转换为xml字符串
     *
     * @param msg
     * @return
     */
    public static String respMessageToXml(AbstractRespMessage msg) {
        XStream xstream = xstream();
        xstream.alias("xml", msg.getClass());
        if (msg instanceof NewsSyncMessage) {
            xstream.alias("item", NewsSyncMessage.Article.class);
        }
        return xstream.toXML(msg);
    }

    /**
     * 将bean转换为xml字符串
     *
     * @param object
     * @return
     */
    public static String beanToXML(Object object) {
        XStream xstream = xstream();
        xstream.alias("xml", object.getClass());
        String xml = xstream.toXML(object);
        return xml.replaceAll("__", "_");
    }

    private static XppDriver xd = new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }


            };
        }
    };

    /**
     * 扩展xstream，使其支持CDATA块，让其忽略不存在的属性
     *
     * @date 2013-05-19
     */
    private static XStream xstream() {
        XStream xStream = new XStream(xd);
        xStream.ignoreUnknownElements();
        return xStream;
    }
}
