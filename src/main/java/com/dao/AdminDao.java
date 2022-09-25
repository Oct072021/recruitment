package com.dao;

import com.bean.Admin;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员DAO层接口
 */
public interface AdminDao {

    /**
     * 通过账号和密码查询用户
     */
    public Admin findAd(@Param("username") String username,
                        @Param("password") String password);

}
