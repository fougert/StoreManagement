package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.rehoshi.dao.ProductMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.ProductPageSearch;
import com.rehoshi.model.Product;
import com.rehoshi.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper ;

    @Override
    public RespData<String> packing(Product product) {
        return null;
    }

    @Override
    public PageData<Product> productInPage(ProductPageSearch search, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageIndex) ;
        List<Product> bySearch = productMapper.getBySearch(search);
        return new PageData<>(bySearch);
    }

    @Override
    public RespData<Product> getById(String id) {
        return null;
    }

    @Override
    public RespData<Boolean> update(Product product) {
        return null;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        return null;
    }
}
