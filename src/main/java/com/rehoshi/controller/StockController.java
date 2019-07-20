package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Stock;
import com.rehoshi.service.StockService;
import com.rehoshi.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public PageData<Stock> stockInPage(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){

        return stockService.stockInPage("",page,limit);

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
