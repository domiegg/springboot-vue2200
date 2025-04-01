/**
 *
 */
package com.ognice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.OrderMapper;
import com.ognice.domain.Order;
import com.ognice.service.IOrderService;
/**
* 
* 订单管理 service接口实现类
*
**/
@Service("orderService")
public class OrderService implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    public Order getOrderById(Long id) {
        return orderMapper.selectOrderById(id);
    }

    public String save(Order record) {
            if (1 == orderMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Order> orders = orderMapper.page(param);
        pageResult.setData(orders);
        param.setPage(null);
        pageResult.setTotal(orderMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Order record) {
        return orderMapper.update(record);
    }
    
    public int delete(Long id) {
        return orderMapper.delete(id);
    }
    
    public List<Order> all() {
		// TODO Auto-generated method stub
		return orderMapper.page(new PageSearchParam());
	}

}
