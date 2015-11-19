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
 * <td>语音为voice</td>
 * </tr>
 * <tr>
 * <td>MediaId</td>
 * <td>语音消息媒体id，可以调用多媒体文件下载接口拉取数据。</td>
 * </tr>
 * <tr>
 * <td>Format</td>
 * <td>语音格式，如amr，speex等</td>
 * </tr>
 * <tr>
 * <td>MsgID</td>
 * <td>消息id，64位整型</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class VoiceMessage extends AbstractNormalMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    // 語音識別結果

    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public final String getRecognition() {
        return Recognition;
    }

    public final void setRecognition(String recognition) {
        Recognition = recognition;
    }
}
