package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 微信订单查询结果
 *
 * @author yy
 */
public class WxOrderInfo {

    /**
     * 查询结果状态码，0 表明成功，其他表明错诨
     */
    private Integer ret_code;
    /**
     * 查询结果出错信息
     */
    private String ret_msg;
    /**
     * 回信息中的编码方式
     */
    private String input_charset;
    /**
     * 订单状态，0 为成功，其他为失败
     */
    private String trade_state;
    /**
     * 交易模式，1 为即时到帐，其他保留
     */
    private String trade_mode;
    /**
     * 财付通商户号，即partnerid
     */
    private String partner;
    /**
     * 银行类型
     */
    private String bank_type;
    /**
     * 银行订单号
     */
    private String bank_billno;
    /**
     * 总金额，单位为分
     */
    private String total_fee;
    /**
     * 币种，1 为人民币
     */
    private String fee_type = "1";
    /**
     * 是财付通订单号
     */
    private String transaction_id;
    /**
     * 第三方订单号
     */
    private String out_trade_no;
    /**
     * 是否分账，false 为无分账，true 为有分账
     */
    private String is_split;
    /**
     * 是否退款，false 为无退款，ture 为退款
     */
    private String is_refund;
    /**
     * 商户数据包，即生成订单 package 时商户填入的 attach
     */
    private String attcah;
    /**
     * 支付完成时间
     */
    private String time_end;
    /**
     * 物流费用，单位为分
     */
    private String transport_fee;
    /**
     * 物品费用，单位为分
     */
    private String product_fee;
    /**
     * 折扣价格，单位为分
     */
    private String discount;
    /**
     * 换算成人民币之后的总金额，单位为分，一般看 total_fee 即可
     */
    private String rmb_total_fee;

    public Integer getRet_code() {
        return ret_code;
    }

    public void setRet_code(Integer ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getTrade_mode() {
        return trade_mode;
    }

    public void setTrade_mode(String trade_mode) {
        this.trade_mode = trade_mode;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getBank_billno() {
        return bank_billno;
    }

    public void setBank_billno(String bank_billno) {
        this.bank_billno = bank_billno;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
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

    public String getIs_split() {
        return is_split;
    }

    public void setIs_split(String is_split) {
        this.is_split = is_split;
    }

    public String getIs_refund() {
        return is_refund;
    }

    public void setIs_refund(String is_refund) {
        this.is_refund = is_refund;
    }

    public String getAttcah() {
        return attcah;
    }

    public void setAttcah(String attcah) {
        this.attcah = attcah;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(String transport_fee) {
        this.transport_fee = transport_fee;
    }

    public String getProduct_fee() {
        return product_fee;
    }

    public void setProduct_fee(String product_fee) {
        this.product_fee = product_fee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRmb_total_fee() {
        return rmb_total_fee;
    }

    public void setRmb_total_fee(String rmb_total_fee) {
        this.rmb_total_fee = rmb_total_fee;
    }

}
