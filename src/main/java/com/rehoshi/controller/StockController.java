package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Goods;
import com.rehoshi.model.Stock;
import com.rehoshi.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
