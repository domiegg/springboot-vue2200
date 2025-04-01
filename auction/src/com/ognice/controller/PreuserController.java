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
import com.ognice.domain.Preuser;
import com.ognice.service.IPreuserService;
import java.util.Date;
/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 用户 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/preuser", method = RequestMethod.GET)
public class PreuserController {
    @Resource
    private IPreuserService preuserService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model, Preuser searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = preuserService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/preuser/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Preuser record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
        record.setCreated(new Date());
            String msg = preuserService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/preuser";
            }
            model.addAttribute("msg", msg);
        }
        return "admin/preuser/form";
    }
	//查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model,Long id) {
    	Preuser record = preuserService.getPreuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/preuser/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model,Long id) {
    	Preuser record = preuserService.getPreuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/preuser/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Preuser record, ModelMap model) {
    	preuserService.update(record);
        return "redirect:/preuser";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model,Long id) {
        preuserService.delete(id);
        return "redirect:/preuser";
    }
}
