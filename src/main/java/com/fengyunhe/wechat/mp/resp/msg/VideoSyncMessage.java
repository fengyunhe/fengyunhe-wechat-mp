package com.fengyunhe.wechat.mp.resp.msg;

/**
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody><tr>
 * <th style="width:120px">参数
 * </th>
 * <th style="width:120px">是否必须
 * </th>
 * <th>说明
 * </th></tr>
 * <tr>
 * <td> ToUserName
 * </td>
 * <td> 是
 * </td>
 * <td> 接收方帐号（收到的OpenID）
 * </td></tr>
 * <tr>
 * <td> FromUserName
 * </td>
 * <td> 是
 * </td>
 * <td> <b>开发者</b>微信号
 * </td></tr>
 * <tr>
 * <td> CreateTime
 * </td>
 * <td> 是
 * </td>
 * <td> 消息创建时间 （整型）
 * </td></tr>
 * <tr>
 * <td> MsgType
 * </td>
 * <td> 是
 * </td>
 * <td> video
 * </td></tr>
 * <tr>
 * <td> MediaId
 * </td>
 * <td> 是
 * </td>
 * <td> 通过上传多媒体文件，得到的id
 * </td></tr>
 * <tr>
 * <td> Title
 * </td>
 * <td> 否
 * </td>
 * <td> 视频消息的标题
 * </td></tr>
 * <tr>
 * <td> Description
 * </td>
 * <td> 否
 * </td>
 * <td> 视频消息的描述
 * </td></tr></tbody></table>
 *
 * @author yangyan
 */
public class VideoSyncMessage extends AbstractRespMessage {


    public VideoSyncMessage() {
        setMsgType(com.fengyunhe.wechat.mp.MsgType.video.name());
    }

    // 媒体ID
    private String MediaId;
    private String Title;
    private String Description;

    public final String getMediaId() {
        return MediaId;
    }

    public final void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public final String getTitle() {
        return Title;
    }

    public final void setTitle(String title) {
        Title = title;
    }

    public final String getDescription() {
        return Description;
    }

    public final void setDescription(String description) {
        Description = description;
    }

}
