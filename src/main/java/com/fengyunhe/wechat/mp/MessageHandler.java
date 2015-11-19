package com.fengyunhe.wechat.mp;

import com.fengyunhe.wechat.mp.req.UnknownRequestMessage;
import com.fengyunhe.wechat.mp.req.msg.*;
import com.fengyunhe.wechat.mp.resp.msg.AbstractRespMessage;

/**
 * 消息处理
 * <p/>
 * 1 文本消息
 * 2 图片消息
 * 3 语音消息
 * 4 视频消息
 * 5 小视频消息
 * 6 地理位置消息
 * 7 链接消息
 *
 * @author yangyan
 */
public interface MessageHandler {

    /**
     * 响应文本消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleText(TextMessage message);

    /**
     * 响应图片消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleImage(ImageMessage message);

    /**
     * 响应链接消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleLink(LinkMessage message);

    /**
     * 响应位置消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleLocation(LocationMessage message);


    /**
     * 响应小视频消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleShortVideo(ShortVideoMessage message);

    /**
     * 响应视频消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleVideo(VideoMessage message);

    /**
     * 响应语音消息
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleVoice(VoiceMessage message);

    /**
     * 响应暂时无法识别的消息类型
     *
     * @param message
     * @return
     */
    public AbstractRespMessage handleUnknownMessage(
            UnknownRequestMessage message);

}
