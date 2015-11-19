package com.fengyunhe.wechat.mp.pay;

import com.fengyunhe.wechat.mp.pay.bean.WarningNotify;

/**
 * 默认微信支付消息事件实现类
 *
 * @author Administrator
 */
public class DefaultPayEventHandlerImpl implements PayEventHandler {

    @Override
    public boolean onWarningNotify(WarningNotify warningNotify) {
        return false;
    }

}
