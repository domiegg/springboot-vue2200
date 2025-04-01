package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Auctionlog;
/**
* 
* 拍卖纪录 dao类
*
**/
public interface AuctionlogMapper {
    int delete(Long id);

    int insert(Auctionlog record);

    Auctionlog selectAuctionlogById(Long id);

    int update(Auctionlog record);

    List<Auctionlog> page(PageSearchParam param);
}