package com.fengyunhe.wechat.mp.api.bean;

public class MediaInfo {


    private String media_id;
    private String created_at;
    private String type;

    public final String getMedia_id() {
        return media_id;
    }

    public final void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public final String getCreated_at() {
        return created_at;
    }

    public final void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

}
