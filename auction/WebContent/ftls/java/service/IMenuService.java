package com.ognice.service;

import java.util.List;

import com.ognice.domain.Menu;

public interface IMenuService {
    public List<Menu> getAllMain();

    public List<Menu> getChild(Long pid);
}
