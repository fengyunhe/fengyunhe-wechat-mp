package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 查询对账单参数
 *
 * @author yangyan
 */
public class QueryStatement {

    // * 商户号 （如 1201200001）
    private String spid;
    // * 下载交易单的日期，格式： 2007-12-26
    private String trans_time;
    // * UNIX 时间戳
    private long stamp;
    // 0:默认值，不需要财付通签名，效率最高；其他保留
    private int cft_signtype;
    // 下载对账单类型
    // 0：默认值，返回当日所有订单；
    // 1：返回当日成功支付的订单
    // 2：返回当日退款的订单
    private int mchtype;
    // * MD5 签名
    // 原串按照上面字段顺序再加商户 key，例如：
    // “spid=2000000501&trans_time=2007-12-26&stamp=11986612
    // 22&cft_signtype=1&mchtype=1&key=$key”。其中 key 可以登
    // 录商户系统修改。
    // 如字段值为空，则不参与签名。如 mchtype 未输入，则 MD5 签
    // 名原始串为：
    // “spid=2000000501&trans_time=2007-12-26&stamp=11986612
    // 22& cft_signtype=1&key=$key” 。
    // 注意：以上拼凑值不要有空格！
    // 使用标准 MD5 算法对该字符串进行加密，加密结果全部转换成
    // 小写后，即为我们所需的 MD5 校验码
    private String sign;

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    public int getCft_signtype() {
        return cft_signtype;
    }

    public void setCft_signtype(int cft_signtype) {
        this.cft_signtype = cft_signtype;
    }

    public int getMchtype() {
        return mchtype;
    }

    public void setMchtype(int mchtype) {
        this.mchtype = mchtype;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
