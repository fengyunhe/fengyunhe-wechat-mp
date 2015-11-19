package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.GroupApi;
import com.fengyunhe.wechat.mp.api.bean.Group;
import com.fengyunhe.wechat.mp.api.bean.Groups;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class GroupApiImpl extends ServerApiImpl implements GroupApi {

    private static final String GROUP_CREATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
    private static final String GROUP_GET_URI = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
    private static final String GROUP_GETID_URI = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
    private static final String GROUP_UPDATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
    private static final String GROUP_MEMBERS_UPDATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";


    public GroupApiImpl(WeChatApp app) {
        super(app);
    }

    /**
     * 创建分组
     *
     * @param accessToken
     * @param name        分组名字（30个字符以内）
     * @return
     * @throws Exception
     */
    public Group create(String accessToken, String name) throws Exception {
        Map<String, Object> group = new HashMap<String, Object>();
        Map<String, Object> nameObj = new HashMap<String, Object>();
        nameObj.put("name", name);
        group.put("group", nameObj);
        String post = JsonObjectUtils.beanToJson(group);
        String result = HttpClientHelper.INSTANCE
                .post(GROUP_CREATE_URI.concat(accessToken), post);
        if (StringUtils.isNotEmpty(result)) {
            return JsonObjectUtils.jsonToBean(result, Group.class);
        }
        return null;
    }

    /**
     * 查询所有分组
     *
     * @param accessToken
     * @return
     * @throws Exception
     */
    public Groups get(String accessToken) throws Exception {
        String result = HttpClientHelper.INSTANCE.get(GROUP_GET_URI.concat(accessToken));
        if (StringUtils.isNotEmpty(result)) {
            return JsonObjectUtils.jsonToBean(result, Groups.class);
        }
        return null;
    }

    /**
     * 查询用户所在分组
     *
     * @param accessToken
     * @param openid      用户的OpenID
     * @return
     * @throws Exception
     */
    public int membersIn(String accessToken, String openid) throws Exception {
        String reslut = HttpClientHelper.INSTANCE.post(GROUP_GETID_URI.concat(accessToken),
                "{\"openid\":\"" + openid + "\"}");
        if (StringUtils.isNotEmpty(reslut)) {
            return JsonObjectUtils.stringToJsonNode(reslut).get("")
                    .getIntValue();
        }
        return 0;
    }

    /**
     * 修改分组名
     *
     * @param accessToken
     * @param id          分组id，由微信分配
     * @param name        分组名字（30个字符以内）
     * @return
     * @throws Exception
     */
    public boolean updateName(String accessToken, String id, String name)
            throws Exception {
        Map<String, Object> group = new HashMap<String, Object>();
        Map<String, Object> nameObj = new HashMap<String, Object>();
        nameObj.put("name", name);
        nameObj.put("id", id);
        group.put("group", nameObj);
        String post = JsonObjectUtils.beanToJson(group);
        String reslut = HttpClientHelper.INSTANCE
                .post(GROUP_UPDATE_URI.concat(accessToken), post);
        if (StringUtils.isNotEmpty(reslut)) {
            return JsonObjectUtils.stringToJsonNode(reslut).get("errcode")
                    .getIntValue() == 0;
        }
        return false;
    }

    /**
     * 移动用户分组
     *
     * @param accessToken
     * @param openid      用户唯一标识符
     * @param to_groupid  分组id
     * @return
     * @throws Exception
     */
    public boolean membersMove(String accessToken, String openid,
                               String to_groupid) throws Exception {
        String reslut = HttpClientHelper.INSTANCE.post(
                GROUP_MEMBERS_UPDATE_URI.concat(accessToken), "{\"openid\":\""
                        + openid + "\",\"to_groupid\":" + to_groupid + "}");
        if (StringUtils.isNotEmpty(reslut)) {
            return JsonObjectUtils.stringToJsonNode(reslut).get("errcode")
                    .getIntValue() == 0;
        }
        return false;
    }
}
