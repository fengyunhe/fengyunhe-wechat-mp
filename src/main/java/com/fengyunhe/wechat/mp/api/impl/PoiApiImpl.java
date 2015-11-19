package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.api.PoiApi;
import com.fengyunhe.wechat.mp.api.bean.PoiInfo;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 门店管理 POI信息管理接口
 * Created by yangyan on 2015/6/2.
 */
public class PoiApiImpl implements PoiApi {

    public static final String URL_ADD_POI = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=";
    public static final String URL_UPDATE_POI = "http://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=";
    public static final String URL_DEL_POI = "http://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=";
    public static final String URL_LIST_POI = "http://api.weixin.qq.com/cgi-bin/poi /getpoilist?access_token=";
    public static final String URL_GET_POT = "http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=";

    @Override
    public boolean addPoi(String accessToken, PoiInfo poi) {
        try {
            JsonNode jsonNode = ErrorCode.check(HttpClientHelper.INSTANCE.post(URL_ADD_POI + accessToken, JsonObjectUtils.beanToJson(poi)));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PoiInfo getPoi(String accessToken, String poiId) {
        String post = null;
        try {
            post = HttpClientHelper.INSTANCE.post(URL_GET_POT + accessToken, JsonObjectUtils.createJson(new String[]{"poi_id"}, new Object[]{poiId}));
            JsonNode jsonNode = ErrorCode.check(post);
            PoiInfo business = JsonObjectUtils.jsonNodeToBean(jsonNode, PoiInfo.class);
            return business;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PoiInfo> getPoiList(String accessToken, Integer begin, Integer limit) {
        String post = null;
        try {
            post = HttpClientHelper.INSTANCE.post(URL_LIST_POI + accessToken, JsonObjectUtils.createJson(new String[]{"begin", "limit"}, new Object[]{begin, limit}));
            JsonNode jsonNode = ErrorCode.check(post);
            JsonNode jsonNode1 = jsonNode.get("business_list");
            if (jsonNode1.size() > 0) {
                List<PoiInfo> list = new ArrayList<PoiInfo>();
                Iterator<JsonNode> iterator = jsonNode1.iterator();

                while (iterator.hasNext()
                        ) {
                    JsonNode next = iterator.next();
                    list.add(JsonObjectUtils.jsonNodeToBean(next, PoiInfo.class));
                }
                return list;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deletePoi(String accessToken, String poiId) {

        String post = null;
        try {
            post = HttpClientHelper.INSTANCE.post(URL_DEL_POI + accessToken, JsonObjectUtils.createJson(new String[]{"poi_id"}, new Object[]{poiId}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(post);
        return true;
    }

    @Override
    public boolean updatePoi(String accessToken, PoiInfo poiInfo) {


        String post = null;
        try {
            post = HttpClientHelper.INSTANCE.post(URL_UPDATE_POI + accessToken, JsonObjectUtils.beanToJson(poiInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(post);
        return true;

//        {"business ":{
//            "base_info":{
//                "poi_id ":"271864249"
//                "telephone ":"020-12345678"
//                "photo_list":[{"photo_url":"https:// XXX.com"}，{"photo_url":"https://
//                    XXX.com"}],
//                    "recommend":"麦辣鸡腿堡套餐，麦乐鸡，全家桶",
//                            "special":"免费 wifi，外卖服务",
//                            "introduction":"麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界
//                    上大约拥有 3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、水
//                    果等快餐食品",
//                    "open_time":"8:00-20:00",
//                            "avg_price":35
//                }
//            }
//        }
    }
}
