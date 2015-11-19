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
 * <td>接收方微信号</td>
 * </tr>
 * <tr>
 * <td>FromUserName</td>
 * <td>发送方微信号，若为普通用户，则是一个OpenID</td>
 * </tr>
 * <tr>
 * <td>CreateTime</td>
 * <td>消息创建时间</td>
 * </tr>
 * <tr>
 * <td>MsgType</td>
 * <td>消息类型，link</td>
 * </tr>
 * <tr>
 * <td>Title</td>
 * <td>消息标题</td>
 * </tr>
 * <tr>
 * <td>Description</td>
 * <td>消息描述</td>
 * </tr>
 * <tr>
 * <td>Url</td>
 * <td>消息链接</td>
 * </tr>
 * <tr>
 * <td>MsgId</td>
 * <td>消息id，64位整型</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class LinkMessage extends AbstractNormalMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
