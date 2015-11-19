package com.fengyunhe.wechat.mp.api.bean;

/**
 * 分裂红包
 * Created by yangyan on 2015/6/26.
 */
public class GroupRedpack {
    /**
     * 详见签名生成算法
     */
    private String nonce_str;
    private String sign;
    private String mch_billno;
    private String mch_id;
    private String sub_mch_id;
    private String wxappid;
    private String send_name;
    private String re_openid;
    private Integer total_amount;
    private Integer total_num;
    private String amt_type = "ALL_RAND";
    private String amt_list = null;
    private String wishing;
    private String act_name;
    private String remark;
    private String logo_imgurl;
    private String watermark_imgurl;
    private String banner_imgurl;
    private String share_imgurl;
    private String share_url;
    private String share_content;


    public String getMch_billno() {
        return mch_billno;
    }

    /**
     * 商户订单号（每个订单号必须唯一）
     * 组成： mch_id+yyyymmdd+10位一天内不能重复的数字。
     * 接口根据商户订单号支持重入， 如出现超时可再调用。
     *
     * @param mch_billno
     */
    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_id() {
        return mch_id;
    }

    /**
     * 微信支付分配的商户号
     *
     * @param mch_id
     */
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    /**
     * 商户appid
     *
     * @param wxappid
     */
    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }


    public String getSend_name() {
        return send_name;
    }

    /**
     * 红包发送者
     *
     * @param send_name
     */
    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getRe_openid() {
        return re_openid;
    }

    /**
     * 接受收红包的用户
     * 用户在wxappid下的openid
     *
     * @param re_openid
     */
    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    /**
     * 付款金额，单位分
     *
     * @param total_amount
     */
    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }


    public Integer getTotal_num() {
        return total_num;
    }

    /**
     * 红包发放总人数
     * total_num=1
     *
     * @param total_num
     */
    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public String getWishing() {
        return wishing;
    }

    /**
     * 红包祝福语
     *
     * @param wishing
     */
    public void setWishing(String wishing) {
        this.wishing = wishing;
    }


    public String getAct_name() {
        return act_name;
    }

    /**
     * 活动名称
     *
     * @param act_name
     */
    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }


    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLogo_imgurl() {
        return logo_imgurl;
    }

    /**
     * 商户logo的url
     *
     * @param logo_imgurl
     */
    public void setLogo_imgurl(String logo_imgurl) {
        this.logo_imgurl = logo_imgurl;
    }


    public String getNonce_str() {
        return nonce_str;
    }

    /**
     * 随机字符串，不长于32位
     *
     * @param nonce_str
     */
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    /**
     * 微信支付分配的子商户号，受理模式下必填
     *
     * @param sub_mch_id
     */
    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }


    public String getAmt_type() {
        return amt_type;
    }

    /**
     * 红包金额设置方式
     * ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
     * ALL_SPECIFIED—全部自定义
     * SEED_SPECIFIED—种子红包自定义，其他随机
     *
     * @param amt_type
     */
    public void setAmt_type(String amt_type) {
        this.amt_type = amt_type;
    }

    public String getAmt_list() {
        return amt_list;
    }

    /**
     * 可选项
     * 例如：200|100|100
     * String(256)
     * 各红包具体金额，自定义金额时必须设置，单位分
     *
     * @param amt_list
     */
    public void setAmt_list(String amt_list) {
        this.amt_list = amt_list;
    }

    public String getWatermark_imgurl() {
        return watermark_imgurl;
    }

    /**
     * 背景水印图片url
     *
     * @param watermark_imgurl
     */
    public void setWatermark_imgurl(String watermark_imgurl) {
        this.watermark_imgurl = watermark_imgurl;
    }

    public String getBanner_imgurl() {
        return banner_imgurl;
    }

    /**
     * 红包详情页面的banner图片url
     *
     * @param banner_imgurl
     */
    public void setBanner_imgurl(String banner_imgurl) {
        this.banner_imgurl = banner_imgurl;
    }

    public String getShare_content() {
        return share_content;
    }

    /**
     * 分享文案
     *
     * @param share_content
     */
    public void setShare_content(String share_content) {
        this.share_content = share_content;
    }

    public String getShare_url() {
        return share_url;
    }

    /**
     * 分享链接
     *
     * @param share_url
     */
    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShare_imgurl() {
        return share_imgurl;
    }

    /**
     * 分享的图片url
     *
     * @param share_imgurl
     */
    public void setShare_imgurl(String share_imgurl) {
        this.share_imgurl = share_imgurl;
    }
}
