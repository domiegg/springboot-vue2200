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
import com.ognice.dao.MsgsMapper;
import com.ognice.domain.Msgs;
import com.ognice.service.IMsgsService;
/**
* 
* 消息管理 service接口实现类
*
**/
@Service("msgsService")
public class MsgsService implements IMsgsService {
    @Resource
    private MsgsMapper msgsMapper;

    public Msgs getMsgsById(Long id) {
        return msgsMapper.selectMsgsById(id);
    }

    public String save(Msgs record) {
            if (1 == msgsMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Msgs> msgss = msgsMapper.page(param);
        pageResult.setData(msgss);
        param.setPage(null);
        pageResult.setTotal(msgsMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Msgs record) {
        return msgsMapper.update(record);
    }
    
    public int delete(Long id) {
        return msgsMapper.delete(id);
    }
    
    public List<Msgs> all() {
		// TODO Auto-generated method stub
		return msgsMapper.page(new PageSearchParam());
	}

}
