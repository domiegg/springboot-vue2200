package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User selectByUsername(String u);

    User login(String u, String p);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> page(PageSearchParam param);
}