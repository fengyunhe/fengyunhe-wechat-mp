package com.fengyunhe.wechat.mp.req.event;

/**
 * 功能：弹出系统拍照发图的事件推送
 * 作者： yangyan
 * 时间： 2014/9/30 .
 */
public class PicSysphoneEvent extends AbstractEventMessage
{
//    <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
//    <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
//    <CreateTime>1408090651</CreateTime>
//    <MsgType><![CDATA[event]]></MsgType>
//    <Event><![CDATA[pic_sysphoto]]></Event>
//    <EventKey><![CDATA[6]]></EventKey>
//    <SendPicsInfo><Count>1</Count>
//    <PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum>
//    </item>
//    </PicList>
//    </SendPicsInfo>
//    </xml>

    private String EventKey;
    private SendPicsInfo SendPicsInfo;

    public String getEventKey()
    {
        return EventKey;
    }

    public void setEventKey(String eventKey)
    {
        EventKey = eventKey;
    }

    public PicSysphoneEvent.SendPicsInfo getSendPicsInfo()
    {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(PicSysphoneEvent.SendPicsInfo sendPicsInfo)
    {
        SendPicsInfo = sendPicsInfo;
    }

    static class SendPicsInfo
    {
        private Integer Count;
        private PicList PicList;

        public Integer getCount()
        {
            return Count;
        }

        public void setCount(Integer count)
        {
            Count = count;
        }

        public PicSysphoneEvent.SendPicsInfo.PicList getPicList()
        {
            return PicList;
        }

        public void setPicList(PicSysphoneEvent.SendPicsInfo.PicList picList)
        {
            PicList = picList;
        }

        static class PicList
        {
            private Item item;

            public Item getItem()
            {
                return item;
            }

            public void setItem(Item item)
            {
                this.item = item;
            }

            static class Item
            {
                public String getPicMd5Sum()
                {
                    return PicMd5Sum;
                }

                public void setPicMd5Sum(String picMd5Sum)
                {
                    PicMd5Sum = picMd5Sum;
                }

                private String PicMd5Sum;
            }
        }
    }
}
