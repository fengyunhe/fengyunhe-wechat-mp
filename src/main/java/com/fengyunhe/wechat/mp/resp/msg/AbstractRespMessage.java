package com.fengyunhe.wechat.mp.resp.msg;

import com.fengyunhe.wechat.mp.api.util.MessageUtil;
import com.fengyunhe.wechat.mp.msg.SyncMessage;

public abstract class AbstractRespMessage extends SyncMessage {
    @Override
    public String toString() {
        return MessageUtil.respMessageToXml(this);
    }
}
