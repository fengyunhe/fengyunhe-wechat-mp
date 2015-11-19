package com.fengyunhe.wechat.mp;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * 公共平台配置
 *
 * @author yangyan
 */
public class WeChatApp {


    WXBizMsgCrypt pc = null;

    /**
     * 基本参数
     *
     * @param appId
     * @param appSecret
     * @param token
     * @param mpId
     */
    public WeChatApp(String appId, String appSecret, String token,String mpId) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.mpId = mpId;
        this.token = token;
    }


    /**
     * 基本参数，支持消息加密传输
     *
     * @param appId
     * @param appSecret
     * @param token
     * @param mpId
     * @param msgEncryptKey
     */
    public WeChatApp(String appId, String appSecret, String token, String mpId, String msgEncryptKey) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
        this.mpId = mpId;
        this.msgEncryptKey = msgEncryptKey;
        try {
            pc = new WXBizMsgCrypt(token, msgEncryptKey, appId);
        } catch (AesException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基本参数，支持微信支付，微信支付配置
     *
     * @param appId
     * @param appSecret
     * @param token
     * @param mpId
     * @param msgEncryptKey
     * @param mchId
     * @param certPath
     * @param certPassword
     * @param payKey
     */
    public WeChatApp(String appId, String appSecret, String token, String mpId, String msgEncryptKey, String mchId, String certPath, String certPassword, String payKey) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
        this.mpId = mpId;
        this.msgEncryptKey = msgEncryptKey;
        try {
            pc = new WXBizMsgCrypt(token, msgEncryptKey, appId);
        } catch (AesException e) {
            e.printStackTrace();
        }
        this.mchId = mchId;
        this.certPath = certPath;
        this.certPassword = certPassword;
        this.payKey = payKey;
    }

    private String appId;
    private String appSecret;
    private String token;
    private String mpId;
    private String msgEncryptKey;

    private String mchId;
    private String certPath;
    private String certPassword;
    private String payKey;

    public String getMpId() {
        return mpId;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    public String getMsgEncryptKey() {
        return msgEncryptKey;
    }

    public void setMsgEncryptKey(String msgEncryptKey) {
        this.msgEncryptKey = msgEncryptKey;
    }


    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    /**
     * 解密微信消息XML
     *
     * @param xml
     * @param msgSignature
     * @param timestamp
     * @param nonce
     * @return
     */
    public String decrypt(String xml, String msgSignature, String timestamp, String nonce) {

        try {
            String s = pc.decryptMsg(msgSignature, timestamp, nonce, xml);
            return s;
        } catch (AesException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密返回的微信消息XML
     *
     * @param xml
     * @param timestamp
     * @param nonce
     * @return
     */
    public String encrypt(String xml, String timestamp, String nonce) {
        try {
            return pc.encryptMsg(xml, timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }

        return null;
    }
}
