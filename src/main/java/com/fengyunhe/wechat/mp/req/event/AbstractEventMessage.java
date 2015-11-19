package com.fengyunhe.wechat.mp.req.event;

import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;

public abstract class AbstractEventMessage extends AbstractRequestMessage {

    // 事件
    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        this.Event = event;
    }
}
