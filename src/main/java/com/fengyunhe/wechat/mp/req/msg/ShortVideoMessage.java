package com.fengyunhe.wechat.mp.req.msg;

import com.fengyunhe.wechat.mp.req.AbstractRequestMessage;

/**
 * Created by yangyan on 2015/11/19.
 *
 * <table border="1" cellspacing="0" cellpadding="4" align="center">
 <tbody><tr>
 <th style="width:180px">参数
 </th>
 <th style="width:470px">描述
 </th></tr>
 <tr>
 <td> ToUserName
 </td>
 <td> <b>开发者</b>微信号
 </td></tr>
 <tr>
 <td> FromUserName
 </td>
 <td> 发送方帐号（一个OpenID）
 </td></tr>
 <tr>
 <td> CreateTime
 </td>
 <td> 消息创建时间 （整型）
 </td></tr>
 <tr>
 <td> MsgType
 </td>
 <td> 小视频为shortvideo
 </td></tr>
 <tr>
 <td> MediaId
 </td>
 <td> 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
 </td></tr>
 <tr>
 <td> ThumbMediaId
 </td>
 <td> 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
 </td></tr>
 <tr>
 <td> MsgId
 </td>
 <td> 消息id，64位整型
 </td></tr></tbody></table>
 */
public class ShortVideoMessage extends AbstractNormalMessage {
    // 媒体ID
    private String MediaId;
    private String ThumbMediaId;

    public final String getMediaId() {
        return MediaId;
    }

    public final void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public final String getThumbMediaId() {
        return ThumbMediaId;
    }

    public final void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
