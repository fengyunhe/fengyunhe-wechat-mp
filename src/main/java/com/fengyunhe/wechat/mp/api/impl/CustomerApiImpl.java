package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.CustomerApi;
import com.fengyunhe.wechat.mp.api.bean.Customer;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.google.common.collect.ImmutableMap;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 客服接口
 * Created by 27716 on 2015/11/19.
 * <p>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody><tr>
 * <th style="width:120px">参数
 * </th>
 * <th style="width:120px">是否必须
 * </th>
 * <th>说明
 * </th></tr>
 * <tr>
 * <td> access_token
 * </td>
 * <td> 是
 * </td>
 * <td> 调用接口凭证
 * </td></tr>
 * <tr>
 * <td> kf_account
 * </td>
 * <td> 是
 * </td>
 * <td> 完整客服账号，格式为：账号前缀@公众号微信号
 * </td></tr>
 * <tr>
 * <td> kf_nick
 * </td>
 * <td> 是
 * </td>
 * <td> 客服昵称
 * </td></tr>
 * <tr>
 * <td> kf_id
 * </td>
 * <td> 是
 * </td>
 * <td> 客服工号
 * </td></tr>
 * <tr>
 * <td> nickname
 * </td>
 * <td> 是
 * </td>
 * <td> 客服昵称，最长6个汉字或12个英文字符
 * </td></tr>
 * <tr>
 * <td> password
 * </td>
 * <td> 否
 * </td>
 * <td> 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
 * </td></tr>
 * <tr>
 * <td> media
 * </td>
 * <td> 是
 * </td>
 * <td> 该参数仅在设置客服头像时出现，是form-data中媒体文件标识，有filename、filelength、content-type等信息
 * </td></tr>
 * </tbody></table>
 */
public class CustomerApiImpl extends ServerApiImpl implements CustomerApi {

    public static final String ADD_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
    public static final String UPDATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
    public static final String DELETE_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=";
    public static final String UPLOAD_HEAD_IMG_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
    public static final String GET_LIST_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";


    public CustomerApiImpl(WeChatApp app) {
        super(app);
    }


    @Override
    public boolean addCustomer(String account, String nickname, String password) {
//        {
//            "kf_account" : "test1@test",
//                "nickname" : "客服1",
//                "password" : "pswmd5",
//        }
        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "kf_account", account,
                "nickname", nickname,
                "password", password
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(ADD_URL + getAccessTokenString(), json);
            ErrorCode.check(jsonStr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(String account, String nickname, String password) {
        //        {
//            "kf_account" : "test1@test",
//                "nickname" : "客服1",
//                "password" : "pswmd5",
//        }
        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "kf_account", account,
                "nickname", nickname,
                "password", password
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(UPDATE_URL + getAccessTokenString(), json);
            ErrorCode.check(jsonStr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String account, String nickname, String password) {


        //        {
//            "kf_account" : "test1@test",
//                "nickname" : "客服1",
//                "password" : "pswmd5",
//        }
        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "kf_account", account,
                "nickname", nickname,
                "password", password
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(DELETE_URL + getAccessTokenString(), json);
            ErrorCode.check(jsonStr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean uploadCustomerImg(String account, File file) {
        String jsonStr = HttpClientHelper.INSTANCE.upload(UPLOAD_HEAD_IMG_URL.replace("ACCESS_TOKEN", getAccessTokenString()).replace("KFACCOUNT", account), file);
        ErrorCode.check(jsonStr);
        return true;
    }

    @Override
    public List<Customer> getCustomerList() {
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(GET_LIST_URL + getAccessTokenString());
            JsonNode check = ErrorCode.check(jsonStr);
            if (check.has("kf_list")) {
                return JsonObjectUtils.jsonToList(jsonStr, new TypeReference<List<Customer>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
