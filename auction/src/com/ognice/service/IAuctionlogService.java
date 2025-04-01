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
import com.ognice.domain.Auctionlog;

/**
* 
* 拍卖纪录 service接口类
*
**/
public interface IAuctionlogService {
	//根据id获取
    public Auctionlog getAuctionlogById(Long id);
	//保存入库
    public String save(Auctionlog record);
    //获取全部数据
    public List<Auctionlog> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Auctionlog record);
    //删除
    public int delete(Long id);

}
