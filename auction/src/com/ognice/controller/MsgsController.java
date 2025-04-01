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
import com.ognice.domain.Msgs;
import com.ognice.service.IMsgsService;
import java.util.Date;
/**
 * @author ..(952396697@qq.com)<br>
 * @date 2019-04-05
 * 消息管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/msgs", method = RequestMethod.GET)
public class MsgsController {
    @Resource
    private IMsgsService msgsService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model, Msgs searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = msgsService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/msgs/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Msgs record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
        record.setCreated(new Date());
            String msg = msgsService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/msgs";
            }
            model.addAttribute("msg", msg);
        }
        return "admin/msgs/form";
    }
	//查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model,Long id) {
    	Msgs record = msgsService.getMsgsById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/msgs/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model,Long id) {
    	Msgs record = msgsService.getMsgsById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/msgs/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Msgs record, ModelMap model) {
    	msgsService.update(record);
        return "redirect:/msgs";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model,Long id) {
        msgsService.delete(id);
        return "redirect:/msgs";
    }
}
