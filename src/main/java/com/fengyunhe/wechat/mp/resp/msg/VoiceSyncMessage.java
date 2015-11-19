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
 * <td> 消息创建时间戳 （整型）
 * </td></tr>
 * <tr>
 * <td> MsgType
 * </td>
 * <td> 是
 * </td>
 * <td> 语音，voice
 * </td></tr>
 * <tr>
 * <td> MediaId
 * </td>
 * <td> 是
 * </td>
 * <td> 通过上传多媒体文件，得到的id
 * </td></tr>
 * </tbody></table>
 */
public class VoiceSyncMessage extends AbstractRespMessage
{

    public VoiceSyncMessage()
    {
        setMsgType(com.fengyunhe.wechat.mp.MsgType.voice.name());
    }

    // 媒体ID
    private String MediaId;

    public String getMediaId()
    {
        return MediaId;
    }

    public void setMediaId(String mediaId)
    {
        MediaId = mediaId;
    }


}
