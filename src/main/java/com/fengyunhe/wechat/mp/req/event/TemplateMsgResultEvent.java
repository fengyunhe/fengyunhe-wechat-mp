package com.fengyunhe.wechat.mp.req.event;

/**
 * Created by 27716 on 2015/11/19.
 */
public class TemplateMsgResultEvent extends AbstractEventMessage {
    int MsgID;
    String Status;

    public int getMsgID() {
        return MsgID;
    }

    public void setMsgID(int msgID) {
        MsgID = msgID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
