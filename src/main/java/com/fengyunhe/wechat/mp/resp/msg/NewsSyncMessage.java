package com.fengyunhe.wechat.mp.resp.msg;

import java.util.List;

/**
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 * <tr>
 * <th style="width:120px">参数</th>
 * <th style="width:120px">是否必须</th>
 * <th>说明</th>
 * </tr>
 * <tr>
 * <td>ToUserName</td>
 * <td>是</td>
 * <td>接收方帐号（收到的OpenID）</td>
 * </tr>
 * <tr>
 * <td>FromUserName</td>
 * <td>是</td>
 * <td><b>开发者</b>微信号</td>
 * </tr>
 * <tr>
 * <td>CreateTime</td>
 * <td>是</td>
 * <td>消息创建时间 （整型）</td>
 * </tr>
 * <tr>
 * <td>MsgType</td>
 * <td>是</td>
 * <td>news</td>
 * </tr>
 * <tr>
 * <td>ArticleCount</td>
 * <td>是</td>
 * <td>图文消息个数，限制为10条以内</td>
 * </tr>
 * <tr>
 * <td>Articles</td>
 * <td>是</td>
 * <td>多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @author zhangdonghao
 */

public class NewsSyncMessage extends AbstractRespMessage {

    public NewsSyncMessage() {
        setMsgType(com.fengyunhe.wechat.mp.MsgType.news.name());
    }

    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    /**
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody> *
     * <tr>
     * <th style="width:120px">参数</th>
     * <th style="width:120px">是否必须</th>
     * <th>说明</th>
     * </tr>
     * <tr>
     * <td>Title</td>
     * <td>否</td>
     * <td>图文消息标题</td>
     * </tr>
     * <tr>
     * <td>Description</td>
     * <td>否</td>
     * <td>图文消息描述</td>
     * </tr>
     * <tr>
     * <td>PicUrl</td>
     * <td>否</td>
     * <td>图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200</td>
     * </tr>
     * <tr>
     * <td>Url</td>
     * <td>否</td>
     * <td>点击图文消息跳转链接</td>
     * </tr>
     * </tbody>
     * </table>
     *
     * @author yangyan
     */
    public static class Article {
        // 图文消息名称
        private String Title;
        // 图文消息描述
        private String Description;
        // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
        private String PicUrl;
        // 点击图文消息跳转链接
        private String Url;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return null == Description ? "" : Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getPicUrl() {
            return null == PicUrl ? "" : PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public String getUrl() {
            return null == Url ? "" : Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

    }

}