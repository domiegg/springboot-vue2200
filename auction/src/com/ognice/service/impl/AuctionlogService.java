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
import com.ognice.dao.AuctionlogMapper;
import com.ognice.domain.Auctionlog;
import com.ognice.service.IAuctionlogService;
/**
* 
* 拍卖纪录 service接口实现类
*
**/
@Service("auctionlogService")
public class AuctionlogService implements IAuctionlogService {
    @Resource
    private AuctionlogMapper auctionlogMapper;

    public Auctionlog getAuctionlogById(Long id) {
        return auctionlogMapper.selectAuctionlogById(id);
    }

    public String save(Auctionlog record) {
            if (1 == auctionlogMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Auctionlog> auctionlogs = auctionlogMapper.page(param);
        pageResult.setData(auctionlogs);
        param.setPage(null);
        pageResult.setTotal(auctionlogMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Auctionlog record) {
        return auctionlogMapper.update(record);
    }
    
    public int delete(Long id) {
        return auctionlogMapper.delete(id);
    }
    
    public List<Auctionlog> all() {
		// TODO Auto-generated method stub
		return auctionlogMapper.page(new PageSearchParam());
	}

}
