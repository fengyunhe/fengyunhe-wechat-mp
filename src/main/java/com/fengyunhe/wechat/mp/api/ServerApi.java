package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.MediaType;
import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.Attachment;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;
import com.fengyunhe.wechat.mp.api.bean.ServerAccessToken;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 通用基础API
 */
public interface ServerApi {

    /**
     * 获取微信服务器的ip列表
     *
     * @return
     */
    List<String> getServerIpList() throws IOException;

    /**
     * 返回公众号accessToken
     *
     * @return
     */
    ServerAccessToken getAccessToken();

    /**
     * 返回公众号的accessToken
     * @return
     */
    String getAccessTokenString();

    /**
     * 下载媒体文件
     *
     * @param accessToken
     * @param mediaId
     * @return
     */
    Attachment getMedia(String accessToken, String mediaId);

    /**
     * 上传媒体文件
     *
     * @param accessToken
     * @param type
     * @param file
     * @return
     */
    MediaInfo uploadMedia(String accessToken, MediaType type, File file);


    /**
     * 上传图片到微信服务器
     *
     * @param accessToken
     * @param file
     * @return 返回微信服务器的图片url
     */
    String uploadImg(String accessToken, File file);

    /**
     * 上传图文素材
     *
     * @param accessToken
     * @param articleList
     * @return
     */
    MediaInfo uploadNews(String accessToken, List<Article> articleList);

    /**
     * 获取临时二维码兑换码
     *
     * @param accessToken
     * @param sceneId
     * @return
     */
    String getTempQrcodeTicket(String accessToken, long sceneId);

    /**
     * 获取二维码兑换码
     *
     * @param accessToken
     * @param sceneId     场景id,数字1-100000
     * @return
     */
    String getQrcodeTicket(String accessToken, int sceneId);

    /**
     * 获取二维码兑换码
     *
     * @param accessToken
     * @param sceneStr    场景字符串,字符串1-64长度
     * @return
     */
    String getQrcodeTicket(String accessToken, String sceneStr);

    /**
     * 获取二维码
     *
     * @param ticket
     * @return
     */
    String getQrcodeUrl(String ticket);

    /**
     * 长连接转短连接
     *
     * @param accessToken
     * @param longUrl
     * @return
     */
    String getShortUrl(String accessToken, String longUrl);
}
