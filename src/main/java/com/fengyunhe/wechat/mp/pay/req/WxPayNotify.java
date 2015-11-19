package com.fengyunhe.wechat.mp.pay.req;

import com.fengyunhe.wechat.mp.api.util.MessageUtil;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信支付通知
 *
 * @author Administrator
 */
public class WxPayNotify {

    /**
     * 签名方式，取值MD5、RSA，默认是MD5
     */
    private String sign_type;
    /**
     * 接口版本，默认1.0
     */
    private String service_version;
    /**
     * 字符编码，取值GBK\UTF-8，默认GBK
     */
    private String input_charset;
    /**
     * 签名
     */
    private String sign;
    /**
     * 密钥序号
     */
    private Integer sign_key_index;

    // 以下为业务参数

    /**
     * 交易模式，1：即时到帐
     */
    private Integer trade_mode;
    /**
     * 交易状态，0：成功
     */
    private Integer trade_state;
    /**
     * 支付结果信息，成功时为空
     */
    private String pay_info;
    /**
     * 商户号
     */
    private String partner;
    /**
     * 银行类型，在微信中使用WX
     */
    private String bank_type;
    /**
     * 银行订单号
     */
    private String bank_billno;
    /**
     * 总金额，单位为分，如果discount有值，则通知的total_fee+discount=请求的total_fee
     */
    private Integer total_fee;
    /**
     * 币种，1：人民币
     */
    private Integer fee_type;
    /**
     * 通知ID，可以用来查询交易结果
     */
    private String notify_id;
    /**
     * 订单号，28位长度，前10位是商户号，之后8位是订单产生的日期，最后10位是流水号
     */
    private String transaction_id;
    /**
     * 商户订单号，商户系统的订单号，与请求一致
     */
    private String out_trade_no;
    /**
     * 商户数据包，原样返回
     */
    private String attach;
    /**
     * 支付完成时间，格式为yyyyMMddHHmmss，时区为GMT+8
     */
    private String time_end;
    /**
     * 物流费用，单位为分，如果有值，必须保证transport_fee+product_fee=total_fee
     */
    private Integer transport_fee;
    /**
     * 物品费用，单位为分
     */
    private Integer product_fee;
    /**
     * 折扣价格，单位为分，如果有值，通 知的 total_fee + discount = 请求的 total_fee
     */
    private Integer discount;

    /**
     * 买家别名，对应买家的一个加密字符串
     */
    private String buyer_alias;

    private WxPayNotifyPostData postData;

    public static class WxPayNotifyPostData {

        /**
         * 公众号ID
         */
        private String AppId;
        /**
         * 1970年1月1日00:00:00至今秒数
         */
        private Integer TimeStamp;

        /**
         * 随机字符串
         */
        private String NonceStr;
        /**
         * 支付该笔订单的用户ID
         */
        private String OpenId;
        /**
         * 签名
         */
        private String AppSignature;

        /**
         * 是否关注了公众号。1：已关注，0：未关注
         */
        private Integer IsSubscribe;

        /**
         * SIGN计算方式
         */
        private String SignMethod;

        public String getAppId() {
            return AppId;
        }

        public void setAppId(String appId) {
            AppId = appId;
        }

        public Integer getTimeStamp() {
            return TimeStamp;
        }

        public void setTimeStamp(Integer timeStamp) {
            TimeStamp = timeStamp;
        }

        public String getNonceStr() {
            return NonceStr;
        }

        public void setNonceStr(String nonceStr) {
            NonceStr = nonceStr;
        }

        public String getOpenId() {
            return OpenId;
        }

        public void setOpenId(String openId) {
            OpenId = openId;
        }

        public String getAppSignature() {
            return AppSignature;
        }

        public void setAppSignature(String appSignature) {
            AppSignature = appSignature;
        }

        public Integer getIsSubscribe() {
            return IsSubscribe;
        }

        public void setIsSubscribe(Integer isSubscribe) {
            IsSubscribe = isSubscribe;
        }

        public String getSignMethod() {
            return SignMethod;
        }

        public void setSignMethod(String signMethod) {
            SignMethod = signMethod;
        }
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getService_version() {
        return service_version;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
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

    public Integer getTrade_mode() {
        return trade_mode;
    }

    public void setTrade_mode(Integer trade_mode) {
        this.trade_mode = trade_mode;
    }

    public Integer getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(Integer trade_state) {
        this.trade_state = trade_state;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
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

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getFee_type() {
        return fee_type;
    }

    public void setFee_type(Integer fee_type) {
        this.fee_type = fee_type;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public Integer getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(Integer transport_fee) {
        this.transport_fee = transport_fee;
    }

    public Integer getProduct_fee() {
        return product_fee;
    }

    public void setProduct_fee(Integer product_fee) {
        this.product_fee = product_fee;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getBuyer_alias() {
        return buyer_alias;
    }

    public void setBuyer_alias(String buyer_alias) {
        this.buyer_alias = buyer_alias;
    }

    public WxPayNotifyPostData getPostData() {
        return postData;
    }

    public void setPostData(WxPayNotifyPostData postData) {
        this.postData = postData;
    }

    /**
     * 填充数据
     *
     * @param request
     * @return
     */
    public WxPayNotify fillDataFromRequest(HttpServletRequest request) {
        try {
            WxPayNotifyPostData data = MessageUtil.requestXmlToMessage(request,
                    WxPayNotifyPostData.class);
            this.setPostData(data);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return this;
    }
}
