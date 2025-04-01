package com.ognice.controller.index;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Preuser;
import com.ognice.domain.Product;
import com.ognice.service.ICateService;
import com.ognice.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 商品 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/index/product", method = RequestMethod.GET)
public class IndexProductController {
    @Resource
    private IProductService productService;
    @Resource
    private ICateService cateService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request, ModelMap model, Product searchParam, Integer page, Integer pageSize) {
        Preuser u = (Preuser) request.getSession().getAttribute("indexUser");
        searchParam.setBuyerid(u.getId());
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = productService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("cates", cateService.all());
        return "pre/product";
    }
    @RequestMapping(value = "/page", method = { RequestMethod.GET, RequestMethod.POST })
    public String index2(HttpServletRequest request, ModelMap model, Product searchParam, Integer page, Integer pageSize) {
        Preuser u = (Preuser) request.getSession().getAttribute("indexUser");
        searchParam.setUid(u.getId());
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = productService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("cates", cateService.all());
        return "pre/productpage";
    }

    // 新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET })
    public String add(HttpServletRequest request, Product record, ModelMap model) {
        model.addAttribute("cates", cateService.all());

        return "pre/addProduct";
    }

    // 新增
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public String save(@RequestParam("file") MultipartFile file, HttpServletRequest request, Product record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            Preuser u = (Preuser) request.getSession().getAttribute("indexUser");
            if(u==null){
                return "redirect:/index/login";

            }
            record.setUid(u.getId());
            record.setUsername(u.getNickname());
            String url = "";

            try {
                record.setCatename(cateService.getCateById(record.getCateid()).getName());

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
            record.setStatus(0);
            String msg = productService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/index/product/page";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("cates", cateService.all());

        return "pre/addProduct";
    }

    // 查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model, Long id) {
        Product record = productService.getProductById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        model.addAttribute("cates", cateService.all());

        return "pre/detail";
    }

    // 编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model, Long id) {
        Product record = productService.getProductById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        model.addAttribute("cates", cateService.all());
        return "pre/addProduct";
    }

    // 更新
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Product record, ModelMap model) {
        productService.update(record);
        return "redirect:/index/product/page";
    }

    // 删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model, Long id) {
        productService.delete(id);
        return "redirect:/index/product/page";
    }
}
