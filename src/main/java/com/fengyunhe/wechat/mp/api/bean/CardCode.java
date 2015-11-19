package com.fengyunhe.wechat.mp.api.bean;

/**
 * 卡券的码
 * Created by yangyan on 2015/6/2.
 */
public class CardCode {

    private String card_id;
    private String code;
    private String openid;
    private String expire_seconds;
    private boolean is_unique_code;
    private Integer balance;
    private Integer outer_id;

    public CardCode() {
    }

    /**
     * @param card_id        卡券 ID
     * @param code           指定卡券 code 码，只能被领一次。use_custom_code 字
     *                       段为 true 的卡券必须填写，非自定义 code 不必填写。
     * @param openid         指定领取者的 openid，只有该用户能领取。bind_openid
     *                       字段为 true 的卡券必须填写， 非自定义 openid 不必填写。
     * @param expire_seconds 指定二维码的有效时间，范围是 60 ~ 1800 秒。不填默认
     *                       为永久有效。
     * @param is_unique_code 指定下发二维码，生成的二维码随机分配一个 code，领取
     *                       后不可再次扫描。填写 true 或 false。默认 false。
     * @param balance        红包余额， 以分为单位。 红包类型必填 （LUCKY_MONEY） ，
     *                       其他卡券类型不填。
     * @param outer_id       领取场景值，用于领取渠道的数据统计，默认值为 0，字
     *                       段类型为整型。用户领取卡券后触发的事件推送中会带上
     *                       此自定义场景值。
     */
    public CardCode(String card_id, String code, String openid, String expire_seconds, boolean is_unique_code, Integer balance, Integer outer_id) {
        this.card_id = card_id;
        this.code = code;
        this.openid = openid;
        this.expire_seconds = expire_seconds;
        this.is_unique_code = is_unique_code;
        this.balance = balance;
        this.outer_id = outer_id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public boolean is_unique_code() {
        return is_unique_code;
    }

    public void setIs_unique_code(boolean is_unique_code) {
        this.is_unique_code = is_unique_code;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(Integer outer_id) {
        this.outer_id = outer_id;
    }
}
