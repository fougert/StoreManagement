package com.rehoshi.service;

import com.rehoshi.dto.RespData;
import com.rehoshi.dto.echart.Echart;

import java.util.Date;

public interface StatisticsService {

    /**
     * 出库统计
     * @param startDate
     * @param endDate
     * @return
     */
    RespData<Echart> outBound(Date startDate,Date endDate);


    /**
     * 成本统计
     * @param startDate
     * @param endDate
     * @return
     */
    RespData<Echart> count(Date startDate,Date endDate);

}
