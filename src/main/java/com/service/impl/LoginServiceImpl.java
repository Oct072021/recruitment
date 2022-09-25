package com.service.impl;

import com.bean.Admin;
import com.bean.Enterprise;
import com.dao.AdminDao;
import com.dao.EnterpriseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.UserDao;
import com.bean.User;
import com.service.LoginService;

/**
 * 用户Service接口实现类
 */
@Service("userService")
@Transactional
public class LoginServiceImpl implements LoginService {
    // 自动注入
    @Autowired
    private UserDao userDao;
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private AdminDao adminDao;

    @Override
    public Enterprise findEn(String username, String password) {
        return this.enterpriseDao.findEn(username, password);
    }

    @Override
    public int addEn(String username, String password) {
        return this.enterpriseDao.addEn(username, password);
    }

    @Override
    public int getEnCount() {
        return this.enterpriseDao.getEnCount();
    }

    @Override
    public Admin findAd(String username, String password) {
        return this.adminDao.findAd(username, password);
    }

    @Override
    public User findUser(String username, String password) {
        return this.userDao.findUser(username, password);
    }

    @Override
    public int addUser(String username, String password) {
        return this.userDao.addUser(username, password);
    }
}
