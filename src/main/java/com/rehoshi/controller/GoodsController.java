package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Goods;
import com.rehoshi.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param page    页号
     * @param limit  每页显示多少条数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goodInPage",method = RequestMethod.GET)
    public PageData<Goods> goodInPage(@RequestParam(value = "page")int page, @RequestParam(value = "limit")int limit){
        return goodsService.goodsInPage("",page,limit);
    }

    /**
     * 添加商品
     * @param name
     * @param type
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/goodsTypeAdd",method = RequestMethod.POST)
    public RespData addGoosType( @RequestParam("name") String name, @RequestParam("type") Integer type){

        return goodsService.addGoodsType(name,type);
    }

    /**
     * 删除单个商品
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delGoodsType/{id}",method = RequestMethod.DELETE)
    public RespData delGoodsType(@PathVariable String id){
        return goodsService.delGoodsType(id);
    }

    /**
     * 修改单个商品
     * @param good
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editGoods",method = RequestMethod.PUT)
    public RespData<Boolean> editGoods(@RequestBody Goods good){
        return goodsService.editGoods(good);
}


    /** 批量删除商品
     *  RequestBody  指定参数json格式
     * @param goodslist
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delBatchGoodsTypes",method = RequestMethod.DELETE)
    public RespData<Boolean> delBatchGoodsTypes(@RequestBody List<Goods> goodslist){
        return goodsService.delBatchGoodTypes(goodslist);
    }


}
