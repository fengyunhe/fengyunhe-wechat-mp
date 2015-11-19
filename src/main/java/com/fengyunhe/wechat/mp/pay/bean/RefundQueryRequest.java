package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 退款查询参数
 *
 * @author yangyan
 */
public class RefundQueryRequest {
    // 协议参数
    private String sign_type;
    private String input_charset;
    private String sign;
    private Integer sign_key_index;
    // 业务参数
    private String partner;
    private String out_trade_no;
    private String transaction_id;
    private String out_refund_no;
    private String refund_id;
    private Integer use_spbill_no_flag;

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

    public Integer getSign_key_index() {
        return sign_key_index;
    }

    public void setSign_key_index(Integer sign_key_index) {
        this.sign_key_index = sign_key_index;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
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

    public Integer getUse_spbill_no_flag() {
        return use_spbill_no_flag;
    }

    public void setUse_spbill_no_flag(Integer use_spbill_no_flag) {
        this.use_spbill_no_flag = use_spbill_no_flag;
    }

}
