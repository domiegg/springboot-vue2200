package com.ognice.controller.index;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Auctionlog;
import com.ognice.domain.Preuser;
import com.ognice.domain.Product;
import com.ognice.service.IAuctionlogService;
import com.ognice.service.IProductService;

/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 拍卖纪录 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/index/auctionlog", method = RequestMethod.GET)
public class IndexAuctionlogController {
    @Resource
    private IAuctionlogService auctionlogService;
    @Resource
    private IProductService productService;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request, ModelMap model, Auctionlog searchParam, Integer page, Integer pageSize) {
        Preuser p = (Preuser) request.getSession().getAttribute("indexUser");
        if (p == null) {
            return "redirect:/index/login";

        }
        searchParam.setUid(p.getId());
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = auctionlogService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "pre/auctionlog";
    }

    // 新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Auctionlog record, ModelMap model) {
        Preuser p = (Preuser) request.getSession().getAttribute("indexUser");
        if (p == null) {
            return "redirect:/index/login";

        }
        if ("post".equals(request.getMethod().toLowerCase())) {
            record.setCreated(new Date());
            String msg = auctionlogService.save(record);

            Product p2 = productService.getProductById(record.getPid());
            p2.setNowprice(p2.getNowprice() + record.getPrice());
            productService.update(p2);
            if (msg.equals("添加成功")) {
                return "redirect:/index/auctionlog";
            }
            model.addAttribute("msg", msg);
        }
        return "redirect:/";
    }

    // 新增
    @RequestMapping(value = "/add2", method = { RequestMethod.GET, RequestMethod.POST })
    public String add2(HttpServletRequest request, Auctionlog record, ModelMap model) {
        Preuser p = (Preuser) request.getSession().getAttribute("indexUser");
        if (p == null) {
            return "redirect:/index/login";

        }
        if ("post".equals(request.getMethod().toLowerCase())) {
            record.setCreated(new Date());
            String msg = auctionlogService.save(record);

            Product p2 = productService.getProductById(record.getPid());
            p2.setBuyerid(p.getId());
            p2.setBuyername(p.getNickname());
            p2.setStatus(2);
            productService.update(p2);
            if (msg.equals("添加成功")) {
                return "redirect:/index/auctionlog";
            }
            model.addAttribute("msg", msg);
        }
        return "redirect:/";
    }

    // 查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model, Long id) {
        Auctionlog record = auctionlogService.getAuctionlogById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        return "admin/auctionlog/form";
    }

    // 编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model, Long id) {
        Auctionlog record = auctionlogService.getAuctionlogById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        return "admin/auctionlog/form";
    }

    // 更新
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Auctionlog record, ModelMap model) {
        auctionlogService.update(record);
        return "redirect:/auctionlog";
    }

    // 删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model, Long id) {
        auctionlogService.delete(id);
        return "redirect:/auctionlog";
    }
}
