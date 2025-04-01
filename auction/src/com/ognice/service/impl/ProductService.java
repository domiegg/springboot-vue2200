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
import com.ognice.dao.ProductMapper;
import com.ognice.domain.Product;
import com.ognice.service.IProductService;
/**
* 
* 商品 service接口实现类
*
**/
@Service("productService")
public class ProductService implements IProductService {
    @Resource
    private ProductMapper productMapper;

    public Product getProductById(Long id) {
        return productMapper.selectProductById(id);
    }

    public String save(Product record) {
            if (1 == productMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Product> products = productMapper.page(param);
        pageResult.setData(products);
        param.setPage(null);
        pageResult.setTotal(productMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Product record) {
        return productMapper.update(record);
    }
    
    public int delete(Long id) {
        return productMapper.delete(id);
    }
    
    public List<Product> all() {
		// TODO Auto-generated method stub
		return productMapper.page(new PageSearchParam());
	}

}
