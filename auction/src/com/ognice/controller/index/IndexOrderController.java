package com.ognice.controller.index;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Order;
import com.ognice.service.IOrderService;
import com.ognice.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ..(952396697@qq.com)<br>
 * @version 1.0
 * @date 2019-04-05
 * 订单管理 controller
 */
@Controller
@RequestMapping(value = "/index/order", method = RequestMethod.GET)
public class IndexOrderController {
    @Resource
    private IOrderService orderService;

    @Resource
    private IProductService productService;

    /**
     * 列表
     */
    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(ModelMap model, Order searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = orderService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "pre/orderpage";
    }

    //新增
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request, Order record, ModelMap model) {
        model.addAttribute("record", record);

        if ("post".equals(request.getMethod().toLowerCase())) {
            // record.setCreated(new Date());
            if(record.getProductid()!=null){
                record.setProductname(productService.getProductById(record.getProductid().longValue()).getTitle());
            }
            record.setStatus(0);
            String msg = orderService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/index/order";
            }
            model.addAttribute("msg", msg);
        }
        return "pre/addOrder";
    }

    //查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model, Long id) {
        Order record = orderService.getOrderById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        return "admin/order/form";
    }

    //编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model, Long id) {
        Order record = orderService.getOrderById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        return "admin/order/form";
    }

    //更新
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request, Order record, ModelMap model) {
        orderService.update(record);
        return "redirect:/order";
    }

    //删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model, Long id) {
        orderService.delete(id);
        return "redirect:/order";
    }
}
