package com.fengyunhe.wechat.mp;

import com.fengyunhe.wechat.mp.req.UnknownRequestMessage;
import com.fengyunhe.wechat.mp.req.msg.*;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;
import com.fengyunhe.wechat.mp.resp.msg.TextSyncMessage;
import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;

public class DefaultMessageHandlerImpl implements MessageHandler {
    // Log log = LogFactory.getLog(this.getClass());
    protected TextSyncMessage defaultResponse(AbstractRequestMessage message) {
//        TextSyncMessage textSyncMessage = new TextSyncMessage();
//        textSyncMessage.setContent(JsonObjectUtils.beanToJson(message));
//        textSyncMessage.setCreateTime(System.currentTimeMillis());
//        textSyncMessage.setFromUserName(message.getToUserName());
//        textSyncMessage.setToUserName(message.getFromUserName());
//        return textSyncMessage;
        return null;
    }

    @Override
    public AbstractRespMessage handleVoice(VoiceMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleVideo(VideoMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleText(TextMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleLocation(LocationMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleShortVideo(ShortVideoMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleLink(LinkMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleImage(ImageMessage message) {
        return defaultResponse(message);
    }

    @Override
    public AbstractRespMessage handleUnknownMessage(
            UnknownRequestMessage message) {
        return defaultResponse(message);
    }
}
