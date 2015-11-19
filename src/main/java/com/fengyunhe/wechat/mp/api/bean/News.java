package com.fengyunhe.wechat.mp.api.bean;

import java.util.List;

public class News {

    private List<Article> articles;

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;

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

        public final String getUrl() {
            return url;
        }

        public final void setUrl(String url) {
            this.url = url;
        }

        public final String getPicurl() {
            return picurl;
        }

        public final void setPicurl(String picurl) {
            this.picurl = picurl;
        }

    }

    public final List<Article> getArticles() {
        return articles;
    }

    public final void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
