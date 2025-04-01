/**
 *
 */
package com.ognice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ognice.controller.common.JsonResult;
import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.User;
import com.ognice.service.IUserService;

/**
 *
 *
 * <br>
 * ========================== <br>
 * 开发：952396697@qq.com <br>
 * 版本：1.0 <br>
 * 创建时间：2016年11月25日 <br>
 * ==========================
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	@Resource
	private IUserService userservice;

	/**
	 *
	 */
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String demo(ModelMap model, User searchParam, Integer page, Integer pageSize) {
		PageSearchParam pageSearch = new PageSearchParam();
		pageSearch.setPage(page == null ? 1 : page);
		pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
		pageSearch.setParams(searchParam);
		PageResult pageResult = userservice.getPages(pageSearch);
		model.addAttribute("datas", pageResult);
		return "admin/user/page";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletRequest request, User u, ModelMap model) {
		if ("post".equals(request.getMethod().toLowerCase())) {
			String msg = userservice.save(u);
			if (msg.equals("添加成功")) {
				return "redirect:/user";
			}
			model.addAttribute("msg", msg);
		}
		return "admin/user/form";
	}

	@RequestMapping(value = "/view")
	public String view(ModelMap model) {
		return "admin/user/form";
	}

	@RequestMapping(value = "/lock")
	@ResponseBody
	public JsonResult lock(@RequestParam Long id) {
		JsonResult result = new JsonResult();
		User u = userservice.getUserById(id);
		if (null == u) {
			result.setResult(false);
			result.setMsg("用户不存在");
		} else {
			if (u.getStatus().equals(0)) {
				u.setStatus(1);
			} else {
				u.setStatus(0);
			}
			userservice.update(u);
			result.setResult(false);
			result.setMsg("操作成功");
		}

		return result;
	}

	@RequestMapping(value = "/edit")
	public String edit(ModelMap model) {
		return "admin/user/form";
	}

}
