/**
 *
 */
package com.ognice.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Product;

/**
* 
* 商品 service接口类
*
**/
public interface IProductService {
	//根据id获取
    public Product getProductById(Long id);
	//保存入库
    public String save(Product record);
    //获取全部数据
    public List<Product> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Product record);
    //删除
    public int delete(Long id);

}
