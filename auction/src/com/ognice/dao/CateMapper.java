package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cate;
/**
* 
* 分类 dao类
*
**/
public interface CateMapper {
    int delete(Long id);

    int insert(Cate record);

    Cate selectCateById(Long id);

    int update(Cate record);

    List<Cate> page(PageSearchParam param);
}