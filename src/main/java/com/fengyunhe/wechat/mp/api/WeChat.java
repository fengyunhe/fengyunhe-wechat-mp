package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.*;
import com.fengyunhe.wechat.mp.api.impl.*;
import com.fengyunhe.wechat.mp.api.util.MessageUtil;
import com.fengyunhe.wechat.mp.msg.SyncMessage;
import com.fengyunhe.wechat.mp.req.event.*;
import com.fengyunhe.wechat.mp.req.msg.*;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信公众号APIs
 */
public class WeChat {

    Log log = LogFactory.getLog(WeChat.class);
    private WeChatApp app;

    private MessageHandler messageHandler;
    private EventHandler eventHandler;
    private GroupApi groupApi;
    private MenuApi menuApi;
    private MessageApi messageApi;
    private ServerApi serverApi;
    private PayApi payApi;
    private UserApi userApi;
    private JsApi jsApi;
    private CardApi cardApi;
    private ShopApi shopApi;

    public WeChat(WeChatApp app) {
        this.app = app;
        this.groupApi = new GroupApiImpl();
        this.menuApi = new MenuApiImpl();
        this.messageApi = new MessageApiImpl();
        this.serverApi = new ServerApiImpl(app);
        this.userApi = new UserApiImpl(app);
        this.jsApi = new JsApiImpl(app);
        this.payApi = new PayApiImpl(app);
    }

    public PayApi getPayApi() {
        return payApi;
    }

    public MessageHandler getMessageHandler() {
        if (messageHandler == null) {
            this.messageHandler = new DefaultMessageHandlerImpl();
        }

        return messageHandler;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public EventHandler getEventHandler() {
        if (eventHandler == null) {
            eventHandler = new DefaultEventHandlerImpl();
        }
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * 根据接收到用户消息进行处理
     *
     * @param request 微信发送过来的xml消息体
     * @return
     */
    public String processing(HttpServletRequest request) {
        String encrypt_type = request.getParameter("encrypt_type");
        String msg_signature = request.getParameter("msg_signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");

        AbstractRespMessage respMessage = null;
        String xml = "";
        try {
            xml = IOUtils.toString(request.getInputStream(), "UTF-8");
            if (StringUtils.isNotBlank(this.app.getMsgEncryptKey())) {
                xml = this.app.decrypt(xml, msg_signature, timestamp, nonce);
            }

            // xml请求解析
            SyncMessage message = MessageUtil.requestXmlToMessage(xml);
            String msgType = message.getMsgType();

            // 文本消息
            if (message == null) {
            } else if (msgType.equals(MsgType.text.name())) {
                respMessage = getMessageHandler().handleText(
                        (TextMessage) message);
            }
            // 图片消息
            else if (msgType.equals(MsgType.image.name())) {
                respMessage = getMessageHandler().handleImage(
                        (ImageMessage) message);
            }
            // 地理位置消息
            else if (msgType.equals(MsgType.location.name())) {
                respMessage = getMessageHandler().handleLocation(
                        (LocationMessage) message);
            }
            // 链接消息
            else if (msgType.equals(MsgType.link.name())) {
                respMessage = getMessageHandler().handleLink(
                        (LinkMessage) message);
            }
            // 音频消息
            else if (msgType.equals(MsgType.voice.name())) {
                respMessage = getMessageHandler().handleVoice(
                        (VoiceMessage) message);
            } //            视频消息
            else if (msgType.equals(MsgType.video.name())) {
                respMessage = getMessageHandler().handleVideo(
                        (VideoMessage) message);
            } //小视频消息 shortvideo
            else if (msgType.equals(MsgType.shortvideo.name())) {
                respMessage = getMessageHandler().handleShortVideo(
                        (ShortVideoMessage) message);
            }
            // 事件推送
            else if (msgType.equals(MsgType.event.name())) {
                // 事件类型
                String eventType = ((AbstractEventMessage) message).getEvent();
                // 订阅
                if (eventType.equals(EventType.subscribe.name())) {

                    if (message instanceof ScanSubscribeEvent) {
                        respMessage = getEventHandler().handleScanSubscribe(
                                (ScanSubscribeEvent) message);
                    } else {
                        respMessage = getEventHandler().handleSubscribe(
                                (SubscribeEvent) message);
                    }

                }
                // 取消订阅
                else if (eventType.equals(EventType.unsubscribe.name())) {
                    respMessage = getEventHandler().handleUnsubscribe(
                            (UnsubscribeEvent) message);
                }
                // 扫码 之前已经订阅
                else if (eventType.equals(EventType.SCAN.name())) {
                    respMessage = getEventHandler().handleScan(
                            (ScanEvent) message);
                }
                // 位置更新
                else if (eventType.equals(EventType.LOCATION.name())) {
                    respMessage = getEventHandler().handleLocation(
                            (LocationEvent) message);
                }
                //群发结果事件
                else if (eventType.equals(EventType.MASSSENDJOBFINISH.name())) {
                    getEventHandler().handleMassSendJobFinsh(
                            (MassSendJobFinshEvent) message);
                }

                // 自定义菜单点击事件
                else if (eventType.equals(EventType.CLICK.name())) {
                    AbstractRespMessage handleMenuClick = getEventHandler()
                            .handleMenuClick((MenuClickEvent) message);
                    respMessage = handleMenuClick;
                }
                // 自定义菜单VIEW点击事件
                else if (eventType.equals(EventType.VIEW.name())) {
                    respMessage = getEventHandler().handleMenuViewClick(
                            (MenuViewClickEvent) message);

                } else if (eventType.equals(EventType.scancode_push.name())) {
                    respMessage = getEventHandler().handleScanCodePushEvent(
                            (ScanCodePushEvent) message);
                } else if (eventType.equals(EventType.scancode_waitmsg.name())) {
                    respMessage = getEventHandler().handleScanCodeWaitMsgEvent(
                            (ScanCodeWaitMsgEvent) message);
                } else if (eventType.equals(EventType.pic_sysphoto.name())) {
                    respMessage = getEventHandler().handlePicSysphoneEvent(
                            (PicSysphoneEvent) message);
                } else if (eventType.equals(EventType.pic_photo_or_album.name())) {
                    respMessage = getEventHandler().handlePicPhotoOrAlbumEvent(
                            (PicPhotoOrAlbumEvent) message);
                } else if (eventType.equals(EventType.pic_weixin.name())) {
                    respMessage = getEventHandler().handlePicWeixinEvent(
                            (PicWeixinEvent) message);
                } else if (eventType.equals(EventType.location_select.name())) {
                    respMessage = getEventHandler().handleLocationSelectEvent(
                            (LocationSelectEvent) message);
                }
            }
        } catch (Exception e) {
            log.error("处理消息出错:" + xml, e);
            e.printStackTrace();
        } finally {
            if (respMessage != null) {
                String msg = respMessage.toString();
                if (StringUtils.isNotBlank(this.app.getMsgEncryptKey())) {
                    msg = this.app.encrypt(msg, String.valueOf(System.currentTimeMillis() / 1000), RandomStringUtils.randomAlphanumeric(5));
                    return msg;
                }
                return msg;
            }
            return "";
        }
    }

    public final GroupApi getGroupApi() {
        return groupApi;
    }

    public final MenuApi getMenuApi() {
        return menuApi;
    }

    public final MessageApi getMessageApi() {
        return messageApi;
    }

    public final ServerApi getServerApi() {
        return serverApi;
    }

    public final UserApi getUserApi() {
        return userApi;
    }

    public JsApi getJsApi() {
        return jsApi;
    }

}
