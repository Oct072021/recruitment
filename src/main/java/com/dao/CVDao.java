package com.dao;

import com.bean.CV;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 简历Dao接口
 */
public interface CVDao {

    public int addCV(@Param("CVPath") String CVPath,
                     @Param("CVName") String CVName,
                     @Param("user_id") int user_id,
                     @Param("com_id") int com_id);

    public List<CV> findCVByCom_id(@Param("com_id") int com_id);

}
