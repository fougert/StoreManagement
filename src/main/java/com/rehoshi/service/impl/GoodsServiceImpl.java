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
import java.util.UUID;

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

    /**
     *
     * @param name 商品名称
     * @param type 商品种类
     * @return
     */
    public RespData addGoodsType(String name, Integer type) {

        List<Goods> goods=goodsMapper.queryByNameAndType(name,type);
        if(goods.size()==0){
             //生成主键
             String uuid=UUID.randomUUID().toString().replaceAll("-","");
            int result=goodsMapper.addGoodsType(uuid,name,type);
            if (result==1){
                return RespData.success(uuid).setCode(200).setMsg("数据库更新成功");
            }else{
                return RespData.fail(false).setCode(0).setMsg("数据库更新异常");
            }
        }else{
            return RespData.fail(false).setCode(0).setMsg("该商品数据库中已存在");
        }

    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    public RespData<Boolean> delGoodsType(String id) {
        int result=goodsMapper.delGoodsType(id);
        if (result==1){
           return RespData.success(true).setCode(200).setMsg("删除成功");
        }else{
          return RespData.fail(false).setCode(0).setMsg("删除失败");
        }
    }

    /**
     * 修改商品
     * @param good
     * @return
     */
    public RespData<Boolean> editGoods(Goods good) {
        int result=goodsMapper.editGoods(good);
        if (result == 0){
            return RespData.fail(false).setCode(0).setMsg("更新异常");
        }else{
            return RespData.success(true).setCode(200).setMsg("成功更新");
        }
    }

    /**
     * 批量删除商品
     * @param goodslist
     * @return
     */
    public RespData<Boolean> delBatchGoodTypes(List<Goods> goodslist) {

        int result=goodsMapper.delBatchGoodTypes(goodslist);
        if(result!=0){
            return RespData.success(true);
        }else{
            return RespData.fail(false);
        }
    }
}
