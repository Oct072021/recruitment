package com.dao;

import com.bean.Enterprise;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * 企业DAO层接口
 */
public interface EnterpriseDao {

    /**
     * 通过账号和密码查询用户
     */
    public Enterprise findEn(@Param("username") String username,
                             @Param("password") String password);

    /**
     * 添加用户
     */
    public int addEn(@Param("username") String username,
                     @Param("password") String password);

    /**
     * 统计用户数量
     */
    public int getEnCount();

}
