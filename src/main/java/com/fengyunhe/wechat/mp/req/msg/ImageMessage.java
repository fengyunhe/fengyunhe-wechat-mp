package com.fengyunhe.wechat.mp.req.msg;

/**
 * <table border="1" cellspacing="0" cellpadding="4" align="center">
 * <tbody>
 * <tr>
 * <th style="width:180px">参数</th>
 * <th style="width:470px">描述</th>
 * </tr>
 * <tr>
 * <td>ToUserName</td>
 * <td><b>开发者</b>微信号</td>
 * </tr>
 * <tr>
 * <td>FromUserName</td>
 * <td>发送方帐号（一个OpenID）</td>
 * </tr>
 * <tr>
 * <td>CreateTime</td>
 * <td>消息创建时间 （整型）</td>
 * </tr>
 * <tr>
 * <td>MsgType</td>
 * <td>image</td>
 * </tr>
 * <tr>
 * <td>PicUrl</td>
 * <td>图片链接</td>
 * </tr>
 * <tr>
 * <td>MediaId</td>
 * <td>图片消息媒体id，可以调用多媒体文件下载接口拉取数据。</td>
 * </tr>
 * <tr>
 * <td>MsgId</td>
 * <td>消息id，64位整型</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class ImageMessage extends AbstractNormalMessage {
    // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public final String getMediaId() {
        return MediaId;
    }

    public final void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}