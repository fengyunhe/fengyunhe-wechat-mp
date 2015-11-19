package com.fengyunhe.wechat.mp.send.msg;

//{
//    "touser":"OPENID",
//    "msgtype":"voice",
//    "voice":
//    {
//      "media_id":"MEDIA_ID"
//    }
//}

import com.fengyunhe.wechat.mp.api.bean.Voice;

/**
 * 语音消息
 *
 * @author Administrator
 */
public class VoiceMsg extends AbstractSendMsg
{
    private Voice voice;

    public Voice getVoice()
    {
        return voice;
    }

    public void setVoice(Voice voice)
    {
        this.voice = voice;
    }

}
