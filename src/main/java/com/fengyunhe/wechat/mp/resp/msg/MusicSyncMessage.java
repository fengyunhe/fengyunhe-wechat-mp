package com.fengyunhe.wechat.mp.resp.msg;

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
 * <td>music</td>
 * </tr>
 * <tr>
 * <td>Title</td>
 * <td>否</td>
 * <td>音乐标题</td>
 * </tr>
 * <tr>
 * <td>Description</td>
 * <td>否</td>
 * <td>音乐描述</td>
 * </tr>
 * <tr>
 * <td>MusicURL</td>
 * <td>否</td>
 * <td>音乐链接</td>
 * </tr>
 * <tr>
 * <td>HQMusicUrl</td>
 * <td>否</td>
 * <td>高质量音乐链接，WIFI环境优先使用该链接播放音乐</td>
 * </tr>
 * <tr>
 * <td>ThumbMediaId</td>
 * <td>是</td>
 * <td>缩略图的媒体id，通过上传多媒体文件，得到的id</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class MusicSyncMessage extends AbstractRespMessage
{

    public MusicSyncMessage()
    {
        setMsgType(com.fengyunhe.wechat.mp.MsgType.music.name());
    }

    // 音乐名称
    private String Title;
    // 音乐描述
    private String Description;
    // 音乐链接
    private String MusicUrl;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;

    private String ThumbMediaId;

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String description)
    {
        Description = description;
    }

    public String getMusicUrl()
    {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl)
    {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl()
    {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String musicUrl)
    {
        HQMusicUrl = musicUrl;
    }

    public final String getThumbMediaId()
    {
        return ThumbMediaId;
    }

    public final void setThumbMediaId(String thumbMediaId)
    {
        ThumbMediaId = thumbMediaId;
    }

}
