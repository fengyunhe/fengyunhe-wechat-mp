package com.fengyunhe.wechat.mp.api.bean;

public class Music {

    private String title;
    private String description;
    private String musicurl;
    private String hqmusicurl;
    private String thumb_media_id;

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final String getMusicurl() {
        return musicurl;
    }

    public final void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public final String getHqmusicurl() {
        return hqmusicurl;
    }

    public final void setHqmusicurl(String hqmusicurl) {
        this.hqmusicurl = hqmusicurl;
    }

    public final String getThumb_media_id() {
        return thumb_media_id;
    }

    public final void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

}
