package com.rehoshi.dto.search;

import java.util.Date;

/**
 * 数据库查询参数
 */
public class StockPageSearch {

    //库存名称
    private String name;
    //入库开始时间
    private Date startTime;
    //入库结束时间
    private Date endTime;

    public String getName() {
        if (name==null){
            name="";
        }
        return "%"+name+"%";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        if (startTime==null){
            startTime=new Date(0);
        }
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        if (endTime==null){
            endTime=new Date();
        }
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
