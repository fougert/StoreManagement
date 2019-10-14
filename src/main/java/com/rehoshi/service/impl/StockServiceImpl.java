package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.GoodsMapper;
import com.rehoshi.dao.StatisticsMapper;
import com.rehoshi.dao.StockMapper;
import com.rehoshi.dao.SupplierMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.model.BaseModel;
import com.rehoshi.model.Goods;
import com.rehoshi.model.Stock;
import com.rehoshi.model.Supplier;
import com.rehoshi.service.StockService;
import com.rehoshi.util.CollectionUtil;
import com.rehoshi.util.ContextUtil;
import com.rehoshi.util.DateUtil;
import com.rehoshi.util.PYUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private StatisticsMapper statisticsMapper;

    @Resource
    private SupplierMapper supplierMapper;

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
            data.setProductAmount(statisticsMapper.getStockProductAmount(data.getId()));
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

        stock.setBatch(getBatch(stock));
        //入库时间
        stock.setCreateTime(new Date());

        assembleStock(stock);

        int result = stockMapper.addStock(stock);

        if (result == 0) {
            //更新失败
            return RespData.fail(false).setCode(0).setMsg("更新异常");

        } else {
            return RespData.success(true).setCode(200).setMsg("入库成功！");
        }
    }

    private int getLastBatchNum(){
        int num = stockMapper.todayCount();
        if(num > 0){//如果今天有插入过得库存
            Stock last = stockMapper.getLast();
            String batch = last.getBatch();
            int length = batch.length() ;
            String numStr = batch.substring(length - 3, length);
            //获取最后插入的序号
            num = Integer.parseInt(numStr) ;
        }
        return num ;
    }

    private String getBatch(Stock stock){
        return getBatch(stock,getLastBatchNum()) ;
    }

    private String getBatch(Stock stock, int lastBatchNum){
        //自动生成批次 首字母大写+日期+序号
        String batch = String.format(Locale.CHINA, "%s%s%03d", PYUtil.getPinYinHeadChar(stock.getName()),
                DateUtil.formatDate("yyyyMMdd", new Date()), lastBatchNum + 1);
        return batch ;
    }

    /**
     * 冗余的库存字段
     *
     * @param stock
     */
    private void assembleStock(Stock stock) {

        stock.setCreatorId(ContextUtil.getCurUser().getId());

        String id = stock.getgId();
        Goods goods = goodsMapper.queryGoodSByID(id);
        stock.setSpecsValue(goods.getSpecsValue());

        String supplierId = stock.getSupplierId();
        Supplier byId = supplierMapper.getById(supplierId);
        if (byId != null) {
            stock.setProvider(byId.getName());
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
        assembleStock(stock);
        int result = stockMapper.editStock(stock);
        if (result == 1) {
            return RespData.success(true).setCode(200).setMsg("更新成功");
        } else {
            return RespData.fail(false).setCode(0).setMsg("更新异常");
        }
    }

    @Override
    public RespData<List<Stock>> list(StockPageSearch search) {
        List<Stock> stocks = stockMapper.queryStockBySearch(search);
        CollectionUtil.foreach(stocks, data -> {
            data.setProductAmount(statisticsMapper.getStockProductAmount(data.getId()));
            data.setWasteAmount(statisticsMapper.getStockWasteAmount(data.getId()));
        });
        return RespData.success(stocks);
    }

    @Override
    public RespData<Boolean> batchSave(List<Stock> stockList) {
        RespData<Boolean> respData = RespData.fail(false).setMsg("批量入库失败") ;
        int num = getLastBatchNum() ;
        long timeMillis = System.currentTimeMillis();
        CollectionUtil.foreach(stockList, (data, index) -> {
            //每个修改时间间隔1毫秒
            data.setCreateTime(new Date(timeMillis + index * 1));
            data.newId();
            assembleStock(data);
            data.setBatch(getBatch(data,num + index));
        });
        int i = stockMapper.batchSave(stockList);
        if(i > 0){
            respData.success().setData(true).setMsg("批量入库成功") ;
        }
        return respData;
    }
}
