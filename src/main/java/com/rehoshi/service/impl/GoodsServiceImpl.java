package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.GoodsMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Goods;
import com.rehoshi.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public RespData<String> save(Goods goods) {
        return null;
    }

    @Override
    public RespData<Boolean> update(Goods goods) {
        return null;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        return null;
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public RespData<List<Goods>> getAllGoods() {
      return null;
    }

    @Override
    public RespData<List<Goods>> getAllMaterial() {
        return null;
    }

    @Override
    public RespData<List<Goods>> getAllPackageMaterial() {
        return null;
    }

    /**
     *
     * @param search 需要查找的关键字
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    @Override
    public PageData<Goods> goodsInPage(String search, int pageIndex, int pageSize){
        //查询之前只需传入页码及每页的大小
        PageHelper.startPage(pageIndex,pageSize);
        //startPage后面紧跟的查询就是分页查询
        List<Goods> goods = goodsMapper.getAllGoods();
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);
        return new PageData<>(goodsPageInfo);
    }
    @Override
    public RespData<Goods> getById(String id) {
        return null;
    }
}
