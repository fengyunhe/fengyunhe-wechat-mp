package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 微信支付订单
 *
 * @author yy
 */
public class WxPayOrder {

    private String bank_type = "WX";
    private String body;
    private String attach;
    private String partner;
    private String out_trade_no;
    private String total_fee;
    private String fee_type = "1";
    private String notify_url;
    private String spbill_create_ip;
    private String time_start;
    private String time_expire;
    private String transport_fee;
    private String product_fee;
    private String goods_tag;
    private String input_charset;

    public String getPartner() {
        return partner;
    }

    /**
     * 商户号
     *
     * @param partner
     */
    public void setPartner(String partner) {
        this.partner = partner;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public String getBody() {
        return body;
    }

    /**
     * 商品描述
     *
     * @return
     */
    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public String getFee_type() {
        return fee_type;
    }

    /**
     * 支付币种，默认1，人民币
     *
     * @param fee_type
     */
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    /**
     * 附加数据
     *
     * @return
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    /**
     * 商户订单号
     *
     * @return
     */
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    /**
     * 订单总金额
     *
     * @return
     */
    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getNotify_url() {
        return notify_url;
    }

    /**
     * 通知URL 255 字节内
     *
     * @return
     */
    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    /**
     * 订单生成的机器IP，购买者IP
     *
     * @return
     */
    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    /**
     * 订单生成时间 yyyyMMddHHmmss
     *
     * @return
     */
    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    /**
     * 订单失效时间 yyyyMMddHHmmss
     *
     * @return
     */
    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getTransport_fee() {
        return transport_fee;
    }

    /**
     * 物流费
     *
     * @param transport_fee
     */
    public void setTransport_fee(String transport_fee) {
        this.transport_fee = transport_fee;
    }

    public String getProduct_fee() {
        return product_fee;
    }

    /**
     * 商品费
     *
     * @return
     */
    public void setProduct_fee(String product_fee) {
        this.product_fee = product_fee;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    /**
     * 商品标记
     *
     * @return
     */
    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    /**
     * 参数的字符编码
     *
     * @return
     */
    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public boolean check() {

        if (bank_type == "" || body == "" || partner == ""
                || out_trade_no == "" || total_fee == "" || fee_type == ""
                || notify_url == null || spbill_create_ip == ""
                || input_charset == "") {

            return false;
        }
        return true;
    }

}
