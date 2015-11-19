package com.fengyunhe.wechat.mp.req.event;

/**
 * 功能：扫码推事件且弹出“消息接收中”提示框的事件推送内容
 * 作者： yangyan
 * 时间： 2014/9/30 .
 */
public class ScanCodeWaitMsgEvent extends AbstractEventMessage
{
//    <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
//    <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
//    <CreateTime>1408090606</CreateTime>
//    <MsgType><![CDATA[event]]></MsgType>
//    <Event><![CDATA[scancode_waitmsg]]></Event>
//    <EventKey><![CDATA[6]]></EventKey>
//    <ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>
//    <ScanResult><![CDATA[2]]></ScanResult>
//    </ScanCodeInfo>
//    </xml>


    private String EventKey;
    private ScanCodeInfo ScanCodeInfo;

    public String getEventKey()
    {
        return EventKey;
    }

    public void setEventKey(String eventKey)
    {
        EventKey = eventKey;
    }

    public ScanCodeWaitMsgEvent.ScanCodeInfo getScanCodeInfo()
    {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeWaitMsgEvent.ScanCodeInfo scanCodeInfo)
    {
        ScanCodeInfo = scanCodeInfo;
    }

    static class ScanCodeInfo
    {
        private String ScanType;
        private String ScanResult;

        public String getScanType()
        {
            return ScanType;
        }

        public void setScanType(String scanType)
        {
            ScanType = scanType;
        }

        public String getScanResult()
        {
            return ScanResult;
        }

        public void setScanResult(String scanResult)
        {
            ScanResult = scanResult;
        }
    }

}
