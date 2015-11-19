package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.Customer;

import java.io.File;
import java.util.List;

/**
 * 客服接口
 * Created by 27716 on 2015/11/19.
 */
public interface CustomerApi {


    /**
     * 添加客服账号
     * @param account
     * @param nickname
     * @param password
     * @return
     */
    boolean addCustomer(String account, String nickname, String password);

    /**
     * 修改客服账号
     * @param account
     * @param nickname
     * @param password
     * @return
     */
    boolean updateCustomer(String account, String nickname, String password);

    /**
     * 删除客服账号
     * @param account
     * @param nickname
     * @param password
     * @return
     */
    boolean deleteCustomer(String account, String nickname, String password);

    /**
     * 上传客服头像
     * @param account
     * @param file
     * @return
     */
    boolean uploadCustomerImg(String account, File file);

    /**
     * 查询客服列表
     * @return
     */
    List<Customer> getCustomerList();

}
