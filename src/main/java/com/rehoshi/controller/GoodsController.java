package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Goods;
import com.rehoshi.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    /**
     * 返回所有商品
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/allgoods",method = RequestMethod.GET)
    public PageData<Goods> getAllGoods(){
        return null;
    }

    /**
     * 返回商品分页数据
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goodInPage",method = RequestMethod.GET)
    public PageData<Goods> goodInPage(@RequestParam(value = "page")int page, @RequestParam(value = "limit")int limit){
        return goodsService.goodsInPage("",page,limit);
    }


}
