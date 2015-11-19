package com.fengyunhe.wechat.mp;

import com.fengyunhe.wechat.mp.req.event.*;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;

public interface EventHandler
{

    /**
     * 订阅
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleSubscribe(SubscribeEvent event);

    /**
     * 取消订阅
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleUnsubscribe(UnsubscribeEvent event);

    /**
     * 扫描后订阅
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleScanSubscribe(ScanSubscribeEvent event);

    /**
     * 已订阅扫描
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleScan(ScanEvent event);

    /**
     * 位置变化
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleLocation(LocationEvent event);


    /**
     * 群发消息任务结果
     *
     * @param event
     */
    public void handleMassSendJobFinsh(MassSendJobFinshEvent event);


    /**
     * 点击菜单按钮
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleMenuClick(MenuClickEvent event);

    /**
     * 点击VIEW菜单按钮
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleMenuViewClick(MenuViewClickEvent event);


    /**
     * 扫码推事件的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleScanCodePushEvent(ScanCodePushEvent event);

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleScanCodeWaitMsgEvent(ScanCodeWaitMsgEvent event);

    /**
     * 弹出系统拍照发图的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handlePicSysphoneEvent(PicSysphoneEvent event);

    /**
     * 弹出拍照或者相册发图的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handlePicPhotoOrAlbumEvent(PicPhotoOrAlbumEvent event);

    /**
     * 弹出微信相册发图器的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handlePicWeixinEvent(PicWeixinEvent event);

    /**
     * 弹出地理位置选择器的事件推送
     *
     * @param event
     * @return
     */
    public AbstractRespMessage handleLocationSelectEvent(LocationSelectEvent event);
}
