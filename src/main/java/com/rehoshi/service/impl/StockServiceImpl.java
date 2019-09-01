package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.GoodsMapper;
import com.rehoshi.dao.StatisticsMapper;
import com.rehoshi.dao.StockMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.model.BaseModel;
import com.rehoshi.model.Stock;
import com.rehoshi.service.StockService;
import com.rehoshi.util.CollectionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public RespData<String> save(Stock stock) {
        return null;
    }

    @Override
    public RespData<Boolean> upate(Stock stock) {
        return null;
    }


    /**
     * 分页 条件 查询
     *
     * @param search    查找关键字
     * @param pageIndex 页码
     * @param pageSize  每页数据量
     * @return
     */
    @Override
    public PageData<Stock> stockInPage(StockPageSearch search, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        //List<Stock> stocks=stockMapper.getAllStock(StockPageSearch search);
        List<Stock> stocks = stockMapper.queryStockBySearch(search);
        //查询已发货的库存量
        CollectionUtil.foreach(stocks, data -> {
            data.setProductAmount(statisticsMapper.getStockProductAmount(data.getId())); ;
            data.setWasteAmount(statisticsMapper.getStockWasteAmount(data.getId()));
        });
        PageInfo<Stock> stockPageInfo = new PageInfo<>(stocks);
        return new PageData<>(stockPageInfo);
    }

    @Override
    public RespData<Stock> getById(String id) {
        return null;
    }

    /**
     * 根据库存id 删除库存
     *
     * @param id 需要删除的库存id
     * @return
     */
    @Override
    public RespData<Boolean> deleteById(String id) {
        int result = stockMapper.delByID(id);
        if (result == 0) {
            return RespData.fail(false).setCode(0);
        } else {
            return RespData.success(true).setCode(200);
        }
    }

    /**
     * 添加库存
     *
     * @param stock
     * @return
     */
    public RespData<Boolean> addStock(Stock stock) {
        //库存编号
        stock.setId(BaseModel.generateUUID());

//        //批次
//        String batch = new SimpleDateFormat("yyyyMMddhhmm").format(new Date().getTime());
//        stock.setBatch(batch);
        //入库时间
        stock.setCreateTime(new Date());

        int result = stockMapper.addStock(stock);

        if (result == 0) {
            //更新失败
            return RespData.fail(false).setCode(0).setMsg("更新异常");

        } else {
            return RespData.success(true).setCode(200).setMsg("入库成功！");
        }

    }

    /**
     * 批量删除
     *
     * @param stockList
     * @return
     */
    public RespData<Boolean> delBatchStock(List<Stock> stockList) {

        int result = stockMapper.delBatchStock(stockList);
        if (result == stockList.size()) {
            return RespData.success(true).setCode(200).setMsg("删除成功");

        } else {
            return RespData.fail(false).setCode(0).setMsg("删除失败");
        }


    }

    /**
     * 更新库存
     *
     * @param stock
     * @return
     */
    public RespData<Boolean> editStock(Stock stock) {

        int result = stockMapper.editStock(stock);
        if (result == 1) {
            return RespData.success(true).setCode(200).setMsg("更新成功");
        } else {
            return RespData.fail(false).setCode(0).setMsg("更新异常");
        }
    }
}
