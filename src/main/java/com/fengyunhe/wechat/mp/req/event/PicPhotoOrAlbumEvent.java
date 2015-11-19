package com.fengyunhe.wechat.mp.req.event;

/**
 * 功能：弹出拍照或者相册发图的事件推送内容
 * 作者： yangyan
 * 时间： 2014/9/30 .
 */
public class PicPhotoOrAlbumEvent extends AbstractEventMessage
{
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

    public PicPhotoOrAlbumEvent.SendPicsInfo getSendPicsInfo()
    {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(PicPhotoOrAlbumEvent.SendPicsInfo sendPicsInfo)
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

        public PicPhotoOrAlbumEvent.SendPicsInfo.PicList getPicList()
        {
            return PicList;
        }

        public void setPicList(PicPhotoOrAlbumEvent.SendPicsInfo.PicList picList)
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
