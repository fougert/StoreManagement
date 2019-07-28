package com.rehoshi.service.impl;

import com.rehoshi.dao.ProductMapper;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.echart.Echart;
import com.rehoshi.model.Product;
import com.rehoshi.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 出库统计
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public RespData<Echart> outBound(Date startDate, Date endDate) {
        List<Product> product=productMapper.queryAllProduct();


        return null;
    }

    @Override
    public RespData<Echart> count(Date startDate, Date endDate) {
        return null;
    }


}
