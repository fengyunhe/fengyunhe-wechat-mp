package com.fengyunhe.wechat.mp;

import com.fengyunhe.wechat.mp.req.event.*;
import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;
import com.fengyunhe.wechat.mp.resp.msg.TextSyncMessage;

public class DefaultEventHandlerImpl implements EventHandler
{


    private TextSyncMessage ok(AbstractRequestMessage message)
    {
//        TextSyncMessage textSyncMessage = new TextSyncMessage();
//        textSyncMessage.setContent(message.getMsgType());
//        textSyncMessage.setCreateTime(System.currentTimeMillis());
//        textSyncMessage.setFromUserName(message.getToUserName());
//        textSyncMessage.setToUserName(message.getFromUserName());
//        textSyncMessage.setContent(JsonObjectUtils.beanToJson(message));
//        return textSyncMessage;
        return null;
    }

    @Override
    public AbstractRespMessage handleUnsubscribe(UnsubscribeEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleSubscribe(SubscribeEvent event)
    {

        return ok(event);
    }

    @Override
    public AbstractRespMessage handleScanSubscribe(ScanSubscribeEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleScan(ScanEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleMenuClick(MenuClickEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleLocation(LocationEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleMenuViewClick(MenuViewClickEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleScanCodePushEvent(ScanCodePushEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleScanCodeWaitMsgEvent(ScanCodeWaitMsgEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handlePicSysphoneEvent(PicSysphoneEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handlePicPhotoOrAlbumEvent(PicPhotoOrAlbumEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handlePicWeixinEvent(PicWeixinEvent event)
    {
        return ok(event);
    }

    @Override
    public AbstractRespMessage handleLocationSelectEvent(LocationSelectEvent event)
    {
        return ok(event);
    }

    @Override
    public void handleTemplateMsgResult(TemplateMsgResultEvent message) {

    }

    @Override
    public void handleMassSendJobFinsh(MassSendJobFinshEvent event)
    {

    }
}
