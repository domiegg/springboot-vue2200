package com.ognice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cate;
import com.ognice.service.ICateService;

/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 分类 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/cate", method = RequestMethod.GET)
public class CateController {
    @Resource
    private ICateService cateService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model, Cate searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = cateService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/cate/page";
    }

    // 新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Cate record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = cateService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/cate";
            }
            model.addAttribute("msg", msg);
        }
        return "admin/cate/form";
    }

    // 查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model, Long id) {
        Cate record = cateService.getCateById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        return "admin/cate/form";
    }

    // 编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model, Long id) {
        Cate record = cateService.getCateById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        return "admin/cate/form";
    }

    // 更新
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Cate record, ModelMap model) {
        cateService.update(record);
        return "redirect:/cate";
    }

    // 删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model, Long id) {
        cateService.delete(id);
        return "redirect:/cate";
    }
}
