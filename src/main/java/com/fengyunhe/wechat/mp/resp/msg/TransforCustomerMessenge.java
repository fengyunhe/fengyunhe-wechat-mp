package com.fengyunhe.wechat.mp.resp.msg;

/**
 * 将用户的消息转到客服平台
 * Created by yangyan on 2014/6/15.
 */
public class TransforCustomerMessenge extends AbstractRespMessage {

    public TransforCustomerMessenge() {
        this.setCreateTime(System.currentTimeMillis());
        this.setMsgType("transfer_customer_service");
    }
}
