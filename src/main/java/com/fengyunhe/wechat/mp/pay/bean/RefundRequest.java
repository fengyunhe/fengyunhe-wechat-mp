package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 退款参数
 *
 * @author yangyan
 */
public class RefundRequest {
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
    private Integer total_fee;
    private Integer refund_fee;
    private Integer op_user_id;
    private String op_user_passwd;
    private String recv_user_id;
    private String reccv_user_name;
    private Integer use_spbill_no_flag;
    private Integer refund_type;

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

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(Integer refund_fee) {
        this.refund_fee = refund_fee;
    }

    public Integer getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(Integer op_user_id) {
        this.op_user_id = op_user_id;
    }

    public String getOp_user_passwd() {
        return op_user_passwd;
    }

    public void setOp_user_passwd(String op_user_passwd) {
        this.op_user_passwd = op_user_passwd;
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

    public Integer getUse_spbill_no_flag() {
        return use_spbill_no_flag;
    }

    public void setUse_spbill_no_flag(Integer use_spbill_no_flag) {
        this.use_spbill_no_flag = use_spbill_no_flag;
    }

    public Integer getRefund_type() {
        return refund_type;
    }

    public void setRefund_type(Integer refund_type) {
        this.refund_type = refund_type;
    }

}
