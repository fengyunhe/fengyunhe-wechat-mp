package com.fengyunhe.wechat.mp.req.event;

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
 * <td>消息类型，event</td>
 * </tr>
 * <tr>
 * <td>Event</td>
 * <td>事件类型，CLICK</td>
 * </tr>
 * <tr>
 * <td>EventKey</td>
 * <td>事件KEY值，与自定义菜单接口中KEY值对应</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @author yangyan
 */
public class MenuClickEvent extends AbstractEventMessage {
    private String EventKey;


    public final String getEventKey() {
        return EventKey;
    }

    public final void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

}
