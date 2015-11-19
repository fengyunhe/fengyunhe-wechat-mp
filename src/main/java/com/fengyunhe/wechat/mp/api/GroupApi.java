package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.Group;
import com.fengyunhe.wechat.mp.api.bean.Groups;

/**
 * 用户组API
 */
public interface GroupApi {

    /**
     * 创建分组
     *
     * @param accessToken
     * @param name
     * @return
     * @throws Exception
     */
    Group create(String accessToken, String name) throws Exception;

    /**
     * 返回分组列表
     *
     * @param accessToken
     * @return
     * @throws Exception
     */
    Groups get(String accessToken) throws Exception;

    /**
     * 监测用户在哪个组
     *
     * @param accessToken
     * @param openid
     * @return
     * @throws Exception
     */
    int membersIn(String accessToken, String openid) throws Exception;

    /**
     * 更新分组
     *
     * @param accessToken
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    boolean updateName(String accessToken, String id, String name)
            throws Exception;

    /**
     * 移动用户到分组
     *
     * @param accessToken
     * @param openid
     * @param to_groupid
     * @return
     * @throws Exception
     */
    boolean membersMove(String accessToken, String openid, String to_groupid)
            throws Exception;

}
