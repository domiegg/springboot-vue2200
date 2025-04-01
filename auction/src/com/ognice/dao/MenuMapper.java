package com.ognice.dao;

import java.util.List;

import com.ognice.domain.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    public List<Menu> getAll();

    public List<Menu> getChilds(Long pid);
}