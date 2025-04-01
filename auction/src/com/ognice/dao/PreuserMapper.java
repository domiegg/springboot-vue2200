package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Preuser;

/**
*
* 用户 dao类
*
**/
public interface PreuserMapper {
    int delete(Long id);

    int insert(Preuser record);

    Preuser selectPreuserById(Long id);

    Preuser login(String u, String p);

    int update(Preuser record);

    List<Preuser> page(PageSearchParam param);
}