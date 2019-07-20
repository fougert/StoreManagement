package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.model.Stock;
import com.rehoshi.service.StockService;
import com.rehoshi.service.impl.StockServiceImpl;
import com.rehoshi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockServiceImpl stockService;


    /**
     * 查询所有库存
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stockInPage",method= RequestMethod.GET)
    public PageData<Stock> stockInPage(
                        @RequestParam(required = false)String name,
                        @RequestParam(value = "startTime",required = false)String startTimeStr,
                        @RequestParam(value = "endTime",required = false)String endTimeStr,
                        @RequestParam("page")Integer page,
                        @RequestParam("limit")Integer limit){

        Date startTime = DateUtil.toDate(startTimeStr);
        Date endTime = DateUtil.toDate(endTimeStr);


        if (endTime != null){
            endTime = DateUtil.addTime(endTime, 1, DateUtil.Unit.DAY);
        }

        StockPageSearch search = new StockPageSearch();
        search.setName(name);
        search.setStartTime(startTime);
        search.setEndTime(endTime);
        return stockService.stockInPage(search,page,limit);

    }

    /**
     * 删除库存
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delStock/{id}",method = RequestMethod.DELETE)
    public RespData<Boolean> delStock(@PathVariable String id){
        return stockService.deleteById(id);
    }


    /**
     * 添加库存
     * @param stock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStock",method = RequestMethod.POST)
    public RespData<Boolean> addStock(@RequestBody Stock stock){

       return stockService.addStock(stock);

    }


    @ResponseBody
    @RequestMapping(value = "/delBatchStock",method = RequestMethod.DELETE)
    public RespData<Boolean> delBatchStock(@RequestBody List<Stock> stockList){

        return stockService.delBatchStock(stockList);
    }

}
