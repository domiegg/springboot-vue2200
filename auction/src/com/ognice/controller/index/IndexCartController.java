package com.ognice.controller.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ognice.domain.Product;
import com.ognice.service.ICateService;
import com.ognice.service.IProductService;

/**
 * @author ..(952396697@qq.com)<br>
 * @date 2017-03-16
 * 商品 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/index/cart", method = RequestMethod.GET)
public class IndexCartController {
    @Resource
    private IProductService productService;
    @Resource
    private ICateService cateService;

    // 新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET })
    public String add(HttpServletRequest request, Product record, ModelMap model, Long id) {
        model.addAttribute("cates", cateService.all());
        model.addAttribute("record", productService.getProductById(id));

        return "pre/cart";
    }

    // 新增
    @RequestMapping(value = "/add2", method = { RequestMethod.GET })
    public String add2(HttpServletRequest request, Product record, ModelMap model, Long id) {
        model.addAttribute("cates", cateService.all());
        model.addAttribute("record", productService.getProductById(id));

        return "pre/cart2";
    }

}
