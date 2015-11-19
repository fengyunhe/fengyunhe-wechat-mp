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
 * <td>location</td>
 * </tr>
 * <tr>
 * <td>Location_X</td>
 * <td>地理位置维度</td>
 * </tr>
 * <tr>
 * <td>Location_Y</td>
 * <td>地理位置经度</td>
 * </tr>
 * <tr>
 * <td>Scale</td>
 * <td>地图缩放大小</td>
 * </tr>
 * <tr>
 * <td>Label</td>
 * <td>地理位置信息</td>
 * </tr>
 * <tr>
 * <td>MsgId</td>
 * <td>消息id，64位整型</td>
 * </tr>
 * </tbody>
 * </table>
 */

public class LocationMessage extends AbstractNormalMessage {
    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}