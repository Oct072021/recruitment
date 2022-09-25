package com.service;

import com.bean.Admin;
import com.bean.Enterprise;
import com.bean.User;

/**
 * 用户Service层接口
 */
public interface LoginService {
    // 通过账号和密码查询用户
    public User findUser(String username, String password);

    //添加用户
    public int addUser(String username, String password);

    public Enterprise findEn(String username, String password);

    public int addEn(String username, String password);

    public int getEnCount();

    public Admin findAd(String username, String password);
}
