package com.fengyunhe.wechat.mp.api.bean;

/**
 * Created by machao on 2015/1/28.
 */
public class ServerJsApiTicket {
    private String ticket;
    private Integer expires_in;
    private long authOnTime;
    private long expireOnTime;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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
