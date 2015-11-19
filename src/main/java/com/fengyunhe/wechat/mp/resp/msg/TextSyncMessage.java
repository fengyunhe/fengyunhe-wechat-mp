package com.fengyunhe.wechat.mp.resp.msg;

/**
 * 文本消息
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
 * <td>text</td>
 * </tr>
 * <tr>
 * <td>Content</td>
 * <td>文本消息内容</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class TextSyncMessage extends AbstractRespMessage {

    public TextSyncMessage() {
        this.setMsgType(com.fengyunhe.wechat.mp.MsgType.text.name());
    }

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
