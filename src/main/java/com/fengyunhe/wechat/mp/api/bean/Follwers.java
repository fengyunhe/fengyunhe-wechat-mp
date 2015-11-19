package com.fengyunhe.wechat.mp.api.bean;

import java.util.List;
import java.util.Map;

public class Follwers {
    // {"total":2,"count":2,"data":{"openid":["","OPENID1","OPENID2"]},"next_openid":"NEXT_OPENID"}

    private int total;
    private int count;

    private Map<String, List<String>> data;

    private String next_openid;

    public final int getTotal() {
        return total;
    }

    public final void setTotal(int total) {
        this.total = total;
    }

    public final int getCount() {
        return count;
    }

    public final void setCount(int count) {
        this.count = count;
    }

    public final String getNext_openid() {
        return next_openid;
    }

    public final void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public final List<String> getOpenid() {
        return data.get("openid");
    }

    public final Map<String, List<String>> getData() {
        return data;
    }

    public final void setData(Map<String, List<String>> data) {
        this.data = data;
    }


}
