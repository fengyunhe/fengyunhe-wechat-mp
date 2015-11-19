package com.fengyunhe.wechat.mp.req.event;

/**
 * 未被关注时：
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
 * <td>事件类型，subscribe</td>
 * </tr>
 * <tr>
 * <td>EventKey</td>
 * <td>事件KEY值，qrscene_为前缀，后面为二维码的参数值</td>
 * </tr>
 * <tr>
 * <td>Ticket</td>
 * <td>二维码的ticket，可用来换取二维码图片</td>
 * </tr>
 * </tbody>
 * </table>
 * 已被关注时：
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
 * <td>事件类型，SCAN</td>
 * </tr>
 * <tr>
 * <td>EventKey</td>
 * <td>事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id</td>
 * </tr>
 * <tr>
 * <td>Ticket</td>
 * <td>二维码的ticket，可用来换取二维码图片</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @author yangyan
 */
public class ScanSubscribeEvent extends ScanEvent {

}
