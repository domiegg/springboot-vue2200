package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Product;
/**
* 
* 商品 dao类
*
**/
public interface ProductMapper {
    int delete(Long id);

    int insert(Product record);

    Product selectProductById(Long id);

    int update(Product record);

    List<Product> page(PageSearchParam param);
}