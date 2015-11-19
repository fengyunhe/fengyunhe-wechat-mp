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
 * <td>事件类型，LOCATION</td>
 * </tr>
 * <tr>
 * <td>Latitude</td>
 * <td>地理位置纬度</td>
 * </tr>
 * <tr>
 * <td>Longitude</td>
 * <td>地理位置经度</td>
 * </tr>
 * <tr>
 * <td>Precision</td>
 * <td>地理位置精度</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @author yangyan
 */
public class LocationEvent extends AbstractEventMessage {
    private String Latitude;
    private String Longitude;
    private String Precision;


    public final String getLatitude() {
        return Latitude;
    }

    public final void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public final String getLongitude() {
        return Longitude;
    }

    public final void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public final String getPrecision() {
        return Precision;
    }

    public final void setPrecision(String precision) {
        Precision = precision;
    }

}
