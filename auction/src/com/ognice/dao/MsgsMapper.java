package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Msgs;
/**
* 
* 消息管理 dao类
*
**/
public interface MsgsMapper {
    int delete(Long id);

    int insert(Msgs record);

    Msgs selectMsgsById(Long id);

    int update(Msgs record);

    List<Msgs> page(PageSearchParam param);
}