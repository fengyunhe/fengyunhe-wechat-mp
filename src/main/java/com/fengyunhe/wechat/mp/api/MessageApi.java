package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.*;

/**
 * 微信客服消息API
 */
public interface MessageApi {

    boolean sendMsg(String accessToken, String json);

    boolean sendText(String accessToken, String openId, String text);

    boolean sendImage(String accessToken, String openId, Image image);

    boolean sendVoice(String accessToken, String openId, Voice voice);

    boolean sendVideo(String accessToken, String openId, Video video);

    boolean sendMusic(String accessToken, String openId, Music music);

    boolean sendNews(String accessToken, String openId, News news);


}
