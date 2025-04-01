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
import com.ognice.dao.CateMapper;
import com.ognice.domain.Cate;
import com.ognice.service.ICateService;
/**
* 
* 分类 service接口实现类
*
**/
@Service("cateService")
public class CateService implements ICateService {
    @Resource
    private CateMapper cateMapper;

    public Cate getCateById(Long id) {
        return cateMapper.selectCateById(id);
    }

    public String save(Cate record) {
            if (1 == cateMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Cate> cates = cateMapper.page(param);
        pageResult.setData(cates);
        param.setPage(null);
        pageResult.setTotal(cateMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Cate record) {
        return cateMapper.update(record);
    }
    
    public int delete(Long id) {
        return cateMapper.delete(id);
    }
    
    public List<Cate> all() {
		// TODO Auto-generated method stub
		return cateMapper.page(new PageSearchParam());
	}

}
