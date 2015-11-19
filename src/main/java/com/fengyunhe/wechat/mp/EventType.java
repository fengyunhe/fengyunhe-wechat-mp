package com.fengyunhe.wechat.mp;

/**
 * 事件类型
 */
public enum EventType {
    /**
     * 订阅
     */
    subscribe,
    /**
     * 取消订阅
     */
    unsubscribe,
    /**
     * 扫码
     */
    SCAN,
    /**
     * 上报地理位置
     */
    LOCATION,
    /**
     * 群发任务结束
     */
    MASSSENDJOBFINISH,


    //以下是自定义菜单的事件
    /**
     * 按钮点击
     */
    CLICK,
    /**
     * 进入页面
     */
    VIEW,
    /**
     * 扫码推事件的事件推送
     */
    scancode_push,
    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    scancode_waitmsg,
    /**
     * 弹出系统拍照发图的事件推送
     */
    pic_sysphoto,

    /**
     * 弹出拍照或者相册发图的事件推送
     */
    pic_photo_or_album,
    /**
     * 弹出微信相册发图器的事件推送
     */
    pic_weixin,
    /**
     * 弹出地理位置选择器的事件推送
     */
    location_select,

    /**
     * 门店添加审核通知
     */
    poi_check_notify,
    /**
     * 卡券审核通知
     */
    card_pass_check,
    /**
     * 领取卡券事件推送
     */
    user_get_card,

    /**
     * 删除卡券事件推送
     */
    user_del_card,

    /**
     * 进入会员卡事件推送
     */
    user_view_card,

    /**
     * 核销事件推送
     */
    user_consume_card

}
