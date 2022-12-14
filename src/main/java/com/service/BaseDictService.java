package com.service;

import java.util.List;

import com.bean.BaseDict;

/**
 * 数据字典Service接口
 */
public interface BaseDictService {
    //根据类别代码查询数据字典
    public List<BaseDict> findBaseDictByTypeCode(String typecode);

    //根据id查询数据字典
    public String findBaseDictById(String id);
}
