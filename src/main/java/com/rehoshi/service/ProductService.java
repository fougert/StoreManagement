package com.rehoshi.service;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.Product;
import com.rehoshi.model.ProductComposition;

import java.util.List;

/**
 * 产品业务
 */
public interface ProductService {


    /**
     * 打包产品
     * @param compositionList 所需原料的列表
     * @return
     */
    RespData<String> packing(List<ProductComposition> compositionList) ;

    /**
     * 产品分页列表
     * @param search 查找内容
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    RespData<PageData<Product>> productInPage(String search, int pageIndex, int pageSize) ;

    /**
     * 根据id 查找产品
     * @param id 需要查找的产品id
     * @return
     */
    RespData<Product> getById(String id) ;

    /**
     * 更新产品
     * 根据id更新
     * @param product 需要更新的产品信息
     * @return 成功返回true 失败返回false
     */
    RespData<Boolean> update(Product product) ;

    /**
     * 删除产品
     * 根据id删除
     * @param id 需要删除的产品id
     * @return 成功返回true 失败返回false
     */
    RespData<Boolean> deleteById(String id) ;


}