package com.fengyunhe.wechat.mp.req;

public class UnknownRequestMessage extends AbstractRequestMessage {
    private String message = null;

    public UnknownRequestMessage(String message) {
        this.message = message;
    }
}
