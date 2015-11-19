package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.Menu;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 自定义菜单API
 */
public interface MenuApi {

    boolean createMenu(String accessToken, Menu menu)
            throws KeyManagementException, NoSuchAlgorithmException,
            NoSuchProviderException, IOException;

    Menu getMenuInfo(String accessToken) throws KeyManagementException,
            NoSuchAlgorithmException, NoSuchProviderException, IOException;

    boolean deleteMenu(String accessToken) throws KeyManagementException,
            NoSuchAlgorithmException, NoSuchProviderException, IOException;

}
