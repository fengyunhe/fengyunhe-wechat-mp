package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 退款结果
 *
 * @author yangyan
 */
public class RefundRequestResult {
    // 协议参数
    private String sign_type;
    private String input_charset;
    private String sign;
    // 业务参数
    private Integer recode;
    private String retmsg;
    private String partner;
    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String refund_id;
    private Integer refund_channel;
    private Integer refund_fee;
    private Integer refund_status;
    private String recv_user_id;
    private String reccv_user_name;

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getRecode() {
        return recode;
    }

    public void setRecode(Integer recode) {
        this.recode = recode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public Integer getRefund_channel() {
        return refund_channel;
    }

    public void setRefund_channel(Integer refund_channel) {
        this.refund_channel = refund_channel;
    }

    public Integer getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(Integer refund_fee) {
        this.refund_fee = refund_fee;
    }

    public Integer getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(Integer refund_status) {
        this.refund_status = refund_status;
    }

    public String getRecv_user_id() {
        return recv_user_id;
    }

    public void setRecv_user_id(String recv_user_id) {
        this.recv_user_id = recv_user_id;
    }

    public String getReccv_user_name() {
        return reccv_user_name;
    }

    public void setReccv_user_name(String reccv_user_name) {
        this.reccv_user_name = reccv_user_name;
    }

    /**
     * XML转对象
     *
     * @param string
     * @return
     */
    public static RefundRequestResult parseFromXML(String string) {
//        System.out.println(string);
        return null;
    }

}
