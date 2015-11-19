package com.fengyunhe.wechat.mp.req.msg;

import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;

public abstract class AbstractNormalMessage extends AbstractRequestMessage {
    // 消息id，64位整型
    private long MsgId;

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
