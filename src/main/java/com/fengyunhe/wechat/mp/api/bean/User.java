package com.fengyunhe.wechat.mp.api.bean;

/**
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody><tr>
 * <th style="width:240px">参数
 * </th>
 * <th>说明
 * </th></tr>
 * <tr>
 * <td> subscribe
 * </td>
 * <td> 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
 * </td></tr>
 * <tr>
 * <td> openid
 * </td>
 * <td> 用户的标识，对当前公众号唯一
 * </td></tr>
 * <tr>
 * <td> nickname
 * </td>
 * <td> 用户的昵称
 * </td></tr>
 * <tr>
 * <td> sex
 * </td>
 * <td> 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
 * </td></tr>
 * <tr>
 * <td> city
 * </td>
 * <td> 用户所在城市
 * </td></tr>
 * <tr>
 * <td> country
 * </td>
 * <td> 用户所在国家
 * </td></tr>
 * <tr>
 * <td> province
 * </td>
 * <td> 用户所在省份
 * </td></tr>
 * <tr>
 * <td> language
 * </td>
 * <td> 用户的语言，简体中文为zh_CN
 * </td></tr>
 * <tr>
 * <td> headimgurl
 * </td>
 * <td> 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
 * </td></tr>
 * <tr>
 * <td> subscribe_time
 * </td>
 * <td> 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
 * </td></tr></tbody></table>
 */
public class User {

    private int subscribe;
    private String openid;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private Long subscribe_time;
    private String unionid;

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
