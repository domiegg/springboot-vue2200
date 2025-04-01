package com.ognice.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Product;
import com.ognice.domain.User;
import com.ognice.service.ICateService;
import com.ognice.service.IProductService;

/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 商品 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/product", method = RequestMethod.GET)
public class ProductController {
    @Resource
    private IProductService productService;
    @Resource
    private ICateService cateService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model, Product searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = productService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("cates", cateService.all());
        return "admin/product/page";
    }

    // 新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET })
    public String add(HttpServletRequest request, Product record, ModelMap model) {
        model.addAttribute("cates", cateService.all());

        return "admin/product/form";
    }

    // 新增
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public String save(@RequestParam("file") MultipartFile file, HttpServletRequest request, Product record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            User u = (User) request.getSession().getAttribute("loginUser");
            record.setUid(u.getId());
            record.setUsername(u.getNickname());
            String url = "";

            try {
                record.setCatename(cateService.getCateById(record.getCateid()).getName());
                record.setNowprice(record.getPrice());
                String staticPath = request.getSession().getServletContext().getRealPath("static/imgs/");
                String fileName = new Date().getTime() + ".jpg";
                File targetFile = new File(staticPath, fileName);
                file.transferTo(targetFile);
                url = "http://localhost:" + request.getLocalPort() + request.getSession().getServletContext().getContextPath() + "/static/imgs/" + fileName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (org.apache.commons.lang.StringUtils.isNotBlank(url)) {
                record.setPicurl(url);
            }
            record.setCreated(new Date());
            String msg = productService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/product";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("cates", cateService.all());

        return "admin/product/form";
    }

    // 查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model, Long id) {
        Product record = productService.getProductById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        model.addAttribute("cates", cateService.all());

        return "admin/product/form";
    }

    // 编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model, Long id) {
        Product record = productService.getProductById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        model.addAttribute("cates", cateService.all());
        return "admin/product/form";
    }

    // 更新
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String update(@RequestParam("file") MultipartFile file, HttpServletRequest request, Product record, ModelMap model) {
        String url = "";

        try {
            record.setCatename(cateService.getCateById(record.getCateid()).getName());
            record.setNowprice(record.getPrice());
            if (file.getSize() > 0) {
                String staticPath = request.getSession().getServletContext().getRealPath("static/imgs/");
                String fileName = new Date().getTime() + ".jpg";
                File targetFile = new File(staticPath, fileName);
                file.transferTo(targetFile);
                url = "http://localhost:" + request.getLocalPort() + request.getSession().getServletContext().getContextPath() + "/static/imgs/" + fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(url)) {
            record.setPicurl(url);
        }
        productService.update(record);
        return "redirect:/product";
    }

    // 删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model, Long id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
