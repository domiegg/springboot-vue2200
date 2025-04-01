/**
 *
 */
package com.ognice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.dao.MenuMapper;
import com.ognice.domain.Menu;
import com.ognice.service.IMenuService;

@Service("menuService")
public class MenuService implements IMenuService {
	@Resource
	private MenuMapper menuMapper;

	public List<Menu> getAllMain() {
		// TODO Auto-generated method stub
		return menuMapper.getAll();
	}

	public List<Menu> getChild(Long pid) {
		// TODO Auto-generated method stub
		return menuMapper.getChilds(pid);
	}

}
