/**
 *
 */
package com.ognice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.PreuserMapper;
import com.ognice.domain.Preuser;
import com.ognice.service.IPreuserService;

/**
*
* 用户 service接口实现类
*
**/
@Service("preuserService")
public class PreuserService implements IPreuserService {
    @Resource
    private PreuserMapper preuserMapper;

    public Preuser getPreuserById(Long id) {
        return preuserMapper.selectPreuserById(id);
    }

    public String save(Preuser record) {
        if (1 == preuserMapper.insert(record)) {
            return "添加成功";
        }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Preuser> preusers = preuserMapper.page(param);
        pageResult.setData(preusers);
        param.setPage(null);
        pageResult.setTotal(preuserMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Preuser record) {
        return preuserMapper.update(record);
    }

    public int delete(Long id) {
        return preuserMapper.delete(id);
    }

    public List<Preuser> all() {
        // TODO Auto-generated method stub
        return preuserMapper.page(new PageSearchParam());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ognice.service.IPreuserService#login(java.lang.String,
     * java.lang.String)
     */
    @Override
    public Preuser login(String u, String p) {
        // TODO Auto-generated method stub
        return preuserMapper.login(u, p);
    }

}
