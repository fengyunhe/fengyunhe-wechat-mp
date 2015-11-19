package com.fengyunhe.wechat.mp.api.bean;

/**
 * 卡券的颜色
 * Created by yangyan on 2015/6/2.
 */
public class CardColor {
    private String name;
    private String value;

    public CardColor(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
