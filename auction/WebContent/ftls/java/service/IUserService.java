package com.ognice.service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.User;

public interface IUserService {
    public User getUserById(Long userId);

    public User login(String u, String p);

    public String save(User u);

    public PageResult getPages(PageSearchParam param);

    public int update(User u);
}
