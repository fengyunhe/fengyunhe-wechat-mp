package com.fengyunhe.wechat.mp.req.event;

/**
 * 功能：弹出地理位置选择器的事件推送内容
 * 作者： yangyan
 * 时间： 2014/9/30 .
 */
public class LocationSelectEvent extends AbstractEventMessage
{

//    <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
//    <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
//    <CreateTime>1408091189</CreateTime>
//    <MsgType><![CDATA[event]]></MsgType>
//    <Event><![CDATA[location_select]]></Event>
//    <EventKey><![CDATA[6]]></EventKey>
//    <SendLocationInfo><Location_X><![CDATA[23]]></Location_X>
//    <Location_Y><![CDATA[113]]></Location_Y>
//    <Scale><![CDATA[15]]></Scale>
//    <Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>
//    <Poiname><![CDATA[]]></Poiname>
//    </SendLocationInfo>
//    </xml>

    private String EventKey;
    private SendLocationInfo SendLocationInfo;

    public String getEventKey()
    {
        return EventKey;
    }

    public void setEventKey(String eventKey)
    {
        EventKey = eventKey;
    }

    public LocationSelectEvent.SendLocationInfo getSendLocationInfo()
    {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(LocationSelectEvent.SendLocationInfo sendLocationInfo)
    {
        SendLocationInfo = sendLocationInfo;
    }

    static class SendLocationInfo
    {
        String Location_X;
        String Location_Y;
        String Scale;
        String Label;
        String Poiname;

        public String getLocation_X()
        {
            return Location_X;
        }

        public void setLocation_X(String location_X)
        {
            Location_X = location_X;
        }

        public String getLocation_Y()
        {
            return Location_Y;
        }

        public void setLocation_Y(String location_Y)
        {
            Location_Y = location_Y;
        }

        public String getScale()
        {
            return Scale;
        }

        public void setScale(String scale)
        {
            Scale = scale;
        }

        public String getLabel()
        {
            return Label;
        }

        public void setLabel(String label)
        {
            Label = label;
        }

        public String getPoiname()
        {
            return Poiname;
        }

        public void setPoiname(String poiname)
        {
            Poiname = poiname;
        }
    }

}
