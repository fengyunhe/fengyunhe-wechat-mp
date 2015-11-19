package com.fengyunhe.wechat.mp.api.bean;

/**
 * 发送红包参数
 * Created by yangyan on 2015/6/17.
 * <table class="table" bordercolor="#999999">
 * <tbody><tr>
 * <th width="64" valign="top"><p>字段名 </p></th>
 * <th width="85" valign="top"><p>字段 </p></th>
 * <th width="28" valign="top"><p>必填 </p></th>
 * <th width="94" valign="top"><p>示例值 </p></th>
 * <th width="56" valign="top"><p>类型 </p></th>
 * <th width="239" valign="top"><p>说明 </p></th>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>随机字符串 </p></td>
 * <td width="85" valign="top"><p>nonce_str </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>5K8264ILTKCH16CQ2502SI8ZNMTM67VS </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>随机字符串，不长于32位 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>签名 </p></td>
 * <td width="85" valign="top"><p>sign </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>C380BEC2BFD727A4B6845133519F3AD6 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>详见<a href="?chapter=4_3">签名生成算法</a> </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>商户订单号 </p></td>
 * <td width="85" valign="top"><p>mch_billno </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>10000098201411111234567890 </p></td>
 * <td width="56" valign="top"><p>String(28) </p></td>
 * <td width="239" valign="top"><p>商户订单号（每个订单号必须唯一） </p>
 * <p>组成：&nbsp;mch_id+yyyymmdd+10位一天内不能重复的数字。 </p>
 * <p>接口根据商户订单号支持重入，&nbsp;如出现超时可再调用。 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>商户号 </p></td>
 * <td width="85" valign="top"><p>mch_id </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>10000098 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>微信支付分配的商户号 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>子商户号 </p></td>
 * <td width="85" valign="top"><p>sub_mch_id </p></td>
 * <td width="28" valign="top"><p>否 </p></td>
 * <td width="94" valign="top"><p>10000090 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>微信支付分配的子商户号，受理模式下必填 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>公众账号appid </p></td>
 * <td width="85" valign="top"><p>wxappid </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>wx8888888888888888 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>商户appid </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>提供方名称 </p></td>
 * <td width="85" valign="top"><p>nick_name </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>天虹百货 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>提供方名称 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>商户名称 </p></td>
 * <td width="85" valign="top"><p>send_name </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>天虹百货 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>红包发送者名称 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>用户openid </p></td>
 * <td width="85" valign="top"><p>re_openid </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>oxTWIuGaIt6gTKsQRLau2M0yL16E </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="top"><p>接受收红包的用户 </p>
 * <p>用户在wxappid下的openid </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>付款金额 </p></td>
 * <td width="85" valign="center"><p>total_amount </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>1000 </p></td>
 * <td width="56" valign="top"><p>int </p></td>
 * <td width="239" valign="center"><p>付款金额，单位分 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>最小红包金额 </p></td>
 * <td width="85" valign="center"><p>min_value </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>1000 </p></td>
 * <td width="56" valign="top"><p>int </p></td>
 * <td width="239" valign="center"><p>最小红包金额，单位分 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>最大红包金额 </p></td>
 * <td width="85" valign="center"><p>max_value </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>1000 </p></td>
 * <td width="56" valign="top"><p>int </p></td>
 * <td width="239" valign="center"><p>最大红包金额，单位分 </p>
 * <p>（&nbsp;最小金额等于最大金额：&nbsp;min_value=max_value&nbsp;=total_amount） </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>红包发放总人数 </p></td>
 * <td width="85" valign="center"><p>total_num </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>1 </p></td>
 * <td width="56" valign="top"><p>int </p></td>
 * <td width="239" valign="center"><p>红包发放总人数 </p>
 * <p>total_num=1 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>红包祝福语 </p></td>
 * <td width="85" valign="center"><p>wishing </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>感谢您参加猜灯谜活动，祝您元宵节快乐！ </p></td>
 * <td width="56" valign="top"><p>String(128) </p></td>
 * <td width="239" valign="center"><p>红包祝福语 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="top"><p>Ip地址 </p></td>
 * <td width="85" valign="top"><p>client_ip </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>192.168.0.1 </p></td>
 * <td width="56" valign="top"><p>String(15) </p></td>
 * <td width="239" valign="top"><p>调用接口的机器Ip地址 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>活动名称 </p></td>
 * <td width="85" valign="center"><p>act_name </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>猜灯谜抢红包活动 </p></td>
 * <td width="56" valign="top"><p>String(32) </p></td>
 * <td width="239" valign="center"><p>活动名称 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>备注 </p></td>
 * <td width="85" valign="center"><p>remark </p></td>
 * <td width="28" valign="top"><p>是 </p></td>
 * <td width="94" valign="top"><p>猜越多得越多，快来抢！ </p></td>
 * <td width="56" valign="top"><p>String(256) </p></td>
 * <td width="239" valign="center"><p>备注信息 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>商户logo的url </p></td>
 * <td width="85" valign="center"><p>logo_imgurl </p></td>
 * <td width="28" valign="top"><p>否 </p></td>
 * <td width="94" valign="top"><p>https://wx.gtimg.com/mch/img/ico-logo.png </p></td>
 * <td width="56" valign="top"><p>String(128) </p></td>
 * <td width="239" valign="center"><p>商户logo的url </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>分享文案 </p></td>
 * <td width="85" valign="center"><p>share_content </p></td>
 * <td width="28" valign="top"><p>否 </p></td>
 * <td width="94" valign="top"><p>快来参加猜灯谜活动 </p></td>
 * <td width="56" valign="top"><p>String(256) </p></td>
 * <td width="239" valign="center"><p>分享文案 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>分享链接 </p></td>
 * <td width="85" valign="center"><p>share_url </p></td>
 * <td width="28" valign="top"><p>否 </p></td>
 * <td width="94" valign="top"><p>http://www.qq.com </p></td>
 * <td width="56" valign="top"><p>String(128) </p></td>
 * <td width="239" valign="center"><p>分享链接 </p></td>
 * </tr>
 * <tr>
 * <td width="64" valign="center"><p>分享的图片 </p></td>
 * <td width="85" valign="center"><p>share_imgurl </p></td>
 * <td width="28" valign="top"><p>否 </p></td>
 * <td width="94" valign="top"><p>https://wx.gtimg.com/mch/img/ico-logo.png </p></td>
 * <td width="56" valign="top"><p>String(128) </p></td>
 * <td width="239" valign="center"><p>分享的图片url </p></td>
 * </tr>
 * </tbody></table>
 */
public class RedPack {
//    <sign></sign>
//    <mch_billno></mch_billno>
//    <mch_id></mch_id>
//    <wxappid></wxappid>
//    <nick_name></nick_name>
//    <send_name></send_name>
//    <re_openid></re_openid>
//    <total_amount></total_amount>
//    <min_value></min_value>
//    <max_value></max_value>
//    <total_num></total_num>
//    <wishing></wishing>
//    <client_ip></client_ip>
//    <act_name></act_name>
//    <act_id></act_id>
//    <remark></remark>
//    <logo_imgurl></logo_imgurl>
//    <share_content></share_content>
//    <share_url></share_url>
//    <share_imgurl></share_imgurl>
//    <nonce_str></nonce_str>


    /**
     * 详见签名生成算法
     */
    private String sign;
    private String mch_billno;
    private String mch_id;
    private String sub_mch_id;
    private String wxappid;
    private String nick_name;
    private String send_name;
    private String re_openid;
    private Integer total_amount;
    private Integer min_value;
    private Integer max_value;
    private Integer total_num;
    private String wishing;
    private String client_ip;
    private String act_name;
    private String act_id;
    private String remark;
    private String logo_imgurl;
    private String share_content;
    private String share_url;
    private String share_imgurl;
    private String nonce_str;

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

    public String getNick_name() {
        return nick_name;
    }

    /**
     * 提供方名称
     *
     * @param nick_name
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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

    public Integer getMin_value() {
        return min_value;
    }

    /**
     * 最小红包金额，单位分
     *
     * @param min_value
     */
    public void setMin_value(Integer min_value) {
        this.min_value = min_value;
    }

    public Integer getMax_value() {
        return max_value;
    }

    /**
     * 最大红包金额，单位分
     * （ 最小金额等于最大金额： min_value=max_value =total_amount）
     *
     * @param max_value
     */
    public void setMax_value(Integer max_value) {
        this.max_value = max_value;
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

    public String getClient_ip() {
        return client_ip;
    }

    /**
     * 调用接口的机器Ip地址
     *
     * @param client_ip
     */
    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
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

    public String getAct_id() {
        return act_id;
    }

    /**
     * 活动id
     *
     * @param act_id
     */
    public void setAct_id(String act_id) {
        this.act_id = act_id;
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
}
