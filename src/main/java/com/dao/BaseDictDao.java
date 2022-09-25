package com.dao;

import java.util.List;

import com.bean.BaseDict;

/**
 * 数据字典
 */
public interface BaseDictDao {
    // 根据类别代码查询数据字典
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);

    //根据id查询数据字典
    public String findBaseDictById(String id);
}
