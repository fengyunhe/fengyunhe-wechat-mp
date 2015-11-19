package com.fengyunhe.wechat.mp.pay.bean;

public class DeliverNotify {
    // json.put("appid", app.getAppId());
    // json.put("openid", openid);
    // json.put("transid", transid);
    // json.put("out_trade_no", out_trade_no);
    // json.put("deliver_timestamp", deliver_timestamp);
    // json.put("deliver_status", deliver_status);
    // json.put("deliver_msg", deliver_msg);

    private String appid;
    private String openid;
    private String transid;
    private String out_trade_no;
    private String deliver_timestamp;
    private String deliver_status;
    private String deliver_msg;

    // 以上参数参与签名


    private String app_signature;
    private String sign_method;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getDeliver_timestamp() {
        return deliver_timestamp;
    }

    public void setDeliver_timestamp(String deliver_timestamp) {
        this.deliver_timestamp = deliver_timestamp;
    }

    public String getDeliver_status() {
        return deliver_status;
    }

    public void setDeliver_status(String deliver_status) {
        this.deliver_status = deliver_status;
    }

    public String getDeliver_msg() {
        return deliver_msg;
    }

    public void setDeliver_msg(String deliver_msg) {
        this.deliver_msg = deliver_msg;
    }

    public String getApp_signature() {
        return app_signature;
    }

    public void setApp_signature(String app_signature) {
        this.app_signature = app_signature;
    }

    public String getSign_method() {
        return sign_method;
    }

    public void setSign_method(String sign_method) {
        this.sign_method = sign_method;
    }

}
