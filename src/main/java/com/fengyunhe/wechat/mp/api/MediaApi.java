package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.MediaType;
import com.fengyunhe.wechat.mp.api.bean.Article;
import com.fengyunhe.wechat.mp.api.bean.Attachment;
import com.fengyunhe.wechat.mp.api.bean.MediaInfo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 临时素材API
 * Created by 27716 on 2015/11/19.
 */
public interface MediaApi {

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
     * 上传永久图文素材
     *
     * @param accessToken
     * @param articleList
     * @return 返回mediaId
     */
    String  addNews(String accessToken, List<Article> articleList);


    /**
     * 修改永久图文素材
     * @param mediaId
     * @param index
     * @param article
     * @return
     */
    boolean updateNews(String mediaId, int index, Article article);

    /**
     * 上传永久素材
     * @param type
     * @param file
     * @param title 如果是视频素材，则需要 标题
     * @param introduction 如果是视频素材则需要 简介
     * @return 如果是图片类型，则返回url，如果是其他类型，则返回media_id
     */
    String addMaterial(MediaType type, File file, String title, String introduction);


//    void getMaterial(String mediaId, MediaType type);


    /**
     * 删除永久素材
     * @param mediaId
     * @return
     */
    boolean delMaterial(String mediaId);

    /**
     * 获取永久素材的总数
     * @return
     */
    Map<String,Integer> getMaterialCount();

}
