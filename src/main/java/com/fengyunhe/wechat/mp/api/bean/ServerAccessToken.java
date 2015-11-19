package com.fengyunhe.wechat.mp.api.bean;

public class ServerAccessToken {
    private String access_token;
    private Integer expires_in;
    private long authOnTime;
    private long expireOnTime;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public long getAuthOnTime() {
        return authOnTime;
    }

    public void setAuthOnTime(long authOnTime) {
        this.authOnTime = authOnTime;
    }

    public long getExpireOnTime() {
        return expireOnTime;
    }

    public void setExpireOnTime(long expireOnTime) {
        this.expireOnTime = expireOnTime;
    }

}
