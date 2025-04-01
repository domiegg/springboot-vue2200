package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Order;
/**
* 
* 订单管理 dao类
*
**/
public interface OrderMapper {
    int delete(Long id);

    int insert(Order record);

    Order selectOrderById(Long id);

    int update(Order record);

    List<Order> page(PageSearchParam param);
}