package com.rehoshi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.model.Stock;

import java.util.List;

public interface StockService  {

    /**
     * 货物入库
     * 时间自动赋值使用当前时间
     * @param stock 货物信息
     * @return 库存id
     */
    RespData<String> save(Stock stock) ;

    /**
     * 根据id更新库存信息
     * @param stock 库存信息
     * @return 成功返回true  失败返回false
     */
    RespData<Boolean> upate(Stock stock) ;

    /**
     * 库存的分页信息
     * @param search 查找关键字
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    PageData<Stock> stockInPage(StockPageSearch search, int pageIndex, int pageSize) ;

    /**
     * 根据id 获取库存信息
     * @param id 需要获取的库存id
     * @return 返回库存信息
     */
    RespData<Stock> getById(String id) ;

    /**
     * 根据id 删除库存信息
     * @param id 需要删除的库存id
     * @return 成功返回true  失败返回 false
     */
    RespData<Boolean> deleteById(String id) ;

    RespData<Boolean> addStock(Stock stock);

    RespData<Boolean> delBatchStock(List<Stock> stockList);

    RespData<Boolean> editStock(Stock stock);

    RespData<List<Stock>> list(StockPageSearch search);

    /**
     * 批量插入库存
     * @param stockList
     * @return
     */
    RespData<Boolean> batchSave(List<Stock> stockList);
}
