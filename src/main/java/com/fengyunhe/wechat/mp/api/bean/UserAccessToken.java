package com.fengyunhe.wechat.mp.api.bean;

import java.io.Serializable;

public class UserAccessToken implements Serializable {

    // {"access_token":"OezXcEiiBSKSxW0eoylIeKs6nZPLRXhGAx4DpReWpFg7cXxPdfS2aw3KEmiwXZx
    // BUgZUdeGjXTcpKf5aCm5KCCzlVBplF0gR3rVyDDghwH01969oegEEgaWUXl406-sgibLfRb9grR1UYyA
    // 1B-ypmQ","expires_in":7200,"refresh_token":"OezXcEiiBSKSxW0eoylIeKs6nZPLRXhGAx4D
    // pReWpFg7cXxPdfS2aw3KEmiwXZxB7Ismh8GyH-vmAHE5c1SR8bke48-o_L2LKaYjid-eWpYBYMYaztMQ
    // indh0DmDvwS1puqCRExqHF2kRWj4uCbpXw","openid":"o6dsct3R35sklwBc4mv-QCKoB3FQ","sco
    // pe":"snsapi_userinfo"}


    private String refresh_token;
    private String openid;
    private String scope;
    private String access_token;
    private Integer expires_in;
    private long authOnTime;
    private long expireOnTime;
    private String unionid;

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

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public long getExpireOnTime() {
        return expireOnTime;
    }

    public long getAuthOnTime() {
        return authOnTime;
    }

    public void setAuthOnTime(long authOnTime) {
        this.authOnTime = authOnTime;
    }

    public void setExpireOnTime(long expireOnTime) {
        this.expireOnTime = expireOnTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
