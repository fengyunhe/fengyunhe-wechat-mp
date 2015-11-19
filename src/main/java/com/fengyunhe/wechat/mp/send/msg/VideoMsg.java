package com.fengyunhe.wechat.mp.send.msg;

//{
//    "touser":"OPENID",
//    "msgtype":"video",
//    "video":
//    {
//      "media_id":"MEDIA_ID",
//      "title":"TITLE",
//      "description":"DESCRIPTION"
//    }
//}

import com.fengyunhe.wechat.mp.api.bean.Video;

/**
 * 客服消息：视频
 *
 * @author Administrator
 */
public class VideoMsg extends AbstractSendMsg
{
    private Video video;


    public Video getVideo()
    {
        return video;
    }

    public void setVideo(Video video)
    {
        this.video = video;
    }


}
