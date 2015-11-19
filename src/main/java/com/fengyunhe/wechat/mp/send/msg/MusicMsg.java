package com.fengyunhe.wechat.mp.send.msg;

//{
//    "touser":"OPENID",
//    "msgtype":"music",
//    "music":
//    {
//      "title":"MUSIC_TITLE",
//      "description":"MUSIC_DESCRIPTION",
//      "musicurl":"MUSIC_URL",
//      "hqmusicurl":"HQ_MUSIC_URL",
//      "thumb_media_id":"THUMB_MEDIA_ID" 
//    }
//}

import com.fengyunhe.wechat.mp.api.bean.Music;

/**
 * 客服消息：音乐
 *
 * @author Administrator
 */
public class MusicMsg extends AbstractSendMsg
{
    private Music music;


    public Music getMusic()
    {
        return music;
    }

    public void setMusic(Music music)
    {
        this.music = music;
    }


}
