package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.rehoshi.dao.ProductMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.ProductPageSearch;
import com.rehoshi.model.Product;
import com.rehoshi.service.ProductService;
import com.rehoshi.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public RespData<String> packing(Product product) {
        RespData<String> data = RespData.fail("").setMsg("成品添加失败");
        if (product != null) {
            product.newId();
            product.setCreateTime(new Date());
            int save = productMapper.save(product);
            if (save > 0) {
                data.success().setData(product.getId()).setMsg("成品添加成功");
            }
        }
        return data;
    }

    @Override
    public PageData<Product> productInPage(ProductPageSearch search, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Product> bySearch = productMapper.getBySearch(search);
        return new PageData<>(bySearch);
    }

    @Override
    public RespData<Product> getById(String id) {
        return null;
    }

    @Override
    public RespData<Boolean> update(Product product) {
        RespData<Boolean> data = RespData.fail(false).setMsg("成品修改失败");
        if (product != null) {
            if (DateUtil.isAfterNow(product.getCreateTime())) {
                data.setMsg("创建时间不能超过当前时间") ;
            } else {
                int update = productMapper.update(product);
                if (update > 0) {
                    data.success().setData(true).setMsg("成品修改成功");
                }
            }
        }
        return data;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        RespData<Boolean> data = RespData.fail(false).setMsg("成品删除失败");
        int i = productMapper.deleteById(id);
        if (i > 0) {
            data.success().setData(true).setMsg("成品删除成功");
        }
        return data;
    }

    @Override
    public RespData<Boolean> deleteInIds(List<String> ids) {
        RespData<Boolean> data = RespData.fail(false).setMsg("成品批量删除失败");
        int i = productMapper.deleteInIds(ids);
        if (i > 0) {
            data.success().setData(true).setMsg("成品批量删除成功");
        }
        return data;
    }
}
