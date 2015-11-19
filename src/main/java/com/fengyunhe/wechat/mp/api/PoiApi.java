package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.PoiInfo;

import java.util.List;

/**
 * Created by lvsk on 2015/6/2.
 */
public interface PoiApi {

    /**
     * 添加门店
     *
     * @param accessToken
     * @param poi
     * @return
     */
    public boolean addPoi(String accessToken, PoiInfo poi);


    /**
     * 查询门店
     *
     * @param accessToken
     * @param poiId
     * @return
     */
    public PoiInfo getPoi(String accessToken, String poiId);


    /**
     * 查询门店列表
     *
     * @param accessToken
     * @param begin
     * @param limit
     * @return
     */
    public List<PoiInfo> getPoiList(String accessToken, Integer begin, Integer limit);


    /**
     * 删除门店
     *
     * @param accessToken
     * @param poiId
     * @return
     */
    public boolean deletePoi(String accessToken, String poiId);

    /**
     * 修改门店信息，全部字段内容同前，特别注意，以上 7 个字段，若有填写内容则为覆盖更新，若无内容则视为不
     修改，维持原有内容。photo_list 字段为全列表覆盖，若需要增加图片，需将之前图片同样放入
     list 中，在其后增加新增图片。如：已有 A、B、C 三张图片，又要增加 D、E 两张图，则需要调
     用该接口，photo_list 传入 A、B、C、D、E 五张图片的链接。
     * @param accessToken
     * @param poiInfo
     * @return
     */
    public boolean updatePoi(String accessToken, PoiInfo poiInfo);
}
