package com.fengyunhe.wechat.mp.api;

/**
 * 微信API异常类
 * Created by yangyan on 2015/6/2.
 */
public class WechatApiException extends RuntimeException {


    public WechatApiException(String message) {
        super(message);
    }

    public WechatApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
