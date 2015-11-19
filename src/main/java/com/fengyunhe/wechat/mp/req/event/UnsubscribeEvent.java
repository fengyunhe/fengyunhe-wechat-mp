package com.fengyunhe.wechat.mp.req.event;

public class UnsubscribeEvent extends AbstractEventMessage {
    private String EventKey;

    public final String getEventKey() {
        return EventKey;
    }

    public final void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
