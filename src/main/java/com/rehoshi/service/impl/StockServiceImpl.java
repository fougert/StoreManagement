package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.StockMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Stock;
import com.rehoshi.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public RespData<String> save(Stock stock) {
        return null;
    }

    @Override
    public RespData<Boolean> upate(Stock stock) {
        return null;
    }


    /**
     * 分页查询
     * @param search 查找关键字
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    @Override
    public PageData<Stock> stockInPage(String search, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex,pageSize);
        List<Stock> stocks=stockMapper.getAllStock();

        PageInfo<Stock> stockPageInfo = new PageInfo<>(stocks);
        return new PageData<>(stockPageInfo);
    }

    @Override
    public RespData<Stock> getById(String id) {
        return null;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        return null;
    }
}
