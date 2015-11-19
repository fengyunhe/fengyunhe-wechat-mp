package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;

import java.util.List;

/**
 * 功能：群发API，群发接口成功后将会返回msgId，否则将抛出异常
 * 作者： yangyan
 * 时间： 2014/8/16 .
 */
public interface MassApi {



    /**
     * 获取视频素材mediaId
     *
     * @param accessToken
     * @param mediaId
     * @param title
     * @param description
     * @return
     */
    MediaInfo getUploadVideoMediaId(String accessToken, String mediaId, String title, String description);

    /**
     * 群发图文到组
     *
     * @param accessToken
     * @param groupId
     * @param mediaId
     * @return
     */
    public String sendNewsToGroup(String accessToken, String mediaId, String groupId);

    /**
     * 群发图文到多个用户
     *
     * @param accessToken
     * @param mediaId
     * @param openId
     * @return
     */
    public String sendNewsToUsers(String accessToken, String mediaId, String... openId);

    /**
     * 群发文本到组
     *
     * @param accessToken
     * @param content
     * @param groupId
     * @return
     */
    public String sendTextToGroup(String accessToken, String content, String groupId);

    /**
     * 群发文本到多个用户
     *
     * @param accessToken
     * @param content
     * @param openId
     * @return
     */
    public String sendTextToUsers(String accessToken, String content, String... openId);

    /**
     * 群发声音到组
     *
     * @param accessToken
     * @param mediaId
     * @param groupId
     * @return
     */
    public String sendVoiceToGroup(String accessToken, String mediaId, String groupId);

    /**
     * 群发语音到多个用户
     *
     * @param accessToken
     * @param mediaId
     * @param openId
     * @return
     */
    public String sendVoiceToUsers(String accessToken, String mediaId, String... openId);

    /**
     * 群发图片到组
     *
     * @param accessToken
     * @param mediaId
     * @param groupId
     * @return
     */
    public String sendImageToGroup(String accessToken, String mediaId, String groupId);


    /**
     * 群发图片到多个用户
     *
     * @param accessToken
     * @param mediaId
     * @param openId
     * @return
     */
    public String sendImageToUsers(String accessToken, String mediaId, String... openId);

    /**
     * 群发视频到组
     *
     * @param accessToken
     * @param mediaId
     * @param title
     * @param description
     * @param groupId     @return
     */
    public String sendVideoToGroup(String accessToken, String mediaId, String title, String description, String groupId);


    /**
     * 群发视频到多个用户
     *
     * @param accessToken
     * @param mediaId
     * @param title
     * @param descritpion
     * @param openId      @return
     */
    public String sendVideoToUsers(String accessToken, String mediaId, String title, String descritpion, String... openId);


    /**
     * 删除群发消息（图文或视频，其他无法删除）
     *
     * @param accessToken
     * @param msgId
     * @return
     */
    public boolean delete(String accessToken, String msgId);


    /**
     * 预览图文消息
     * @param openId
     * @param mediaId
     * @return
     */
    public boolean previewNews(String openId, String mediaId);

    /**
     * 预览文本消息
     * @param openId
     * @param content
     * @return
     */
    public boolean previewText(String openId, String content);

    /**
     * 预览语音消息
     * @param openId
     * @param mediaId
     * @return
     */
    public boolean previewVoice(String openId, String mediaId);

    /**
     * 预览图片消息
     * @param openId
     * @param mediaId
     * @return
     */
    public boolean previewImage(String openId, String mediaId);

    /**
     * 预览视频消息
     * @param openId
     * @param mediaId
     * @return
     */
    public boolean previewVideo(String openId, String mediaId);

    /**
     * 预览卡劵消息
     * @param openId
     * @param cardId
     * @param cardExt
     * @return
     */
    public boolean previewCard(String openId, String cardId,String cardExt);


    /**
     * 查询群发消息是否发送成功
     * @param msgId
     * @return
     */
    public boolean getMassStatus(int msgId);





}
