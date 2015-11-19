package com.fengyunhe.wechat.mp.pay;

import com.fengyunhe.wechat.mp.pay.bean.WarningNotify;

/**
 * 微信支付消息事件
 *
 * @author Administrator
 */
public interface PayEventHandler {
    /**
     * 当警告通知
     *
     * @param warningNotify
     * @return
     */
    public boolean onWarningNotify(WarningNotify warningNotify);

}
