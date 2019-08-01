package com.rehoshi.model;

import com.rehoshi.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 损耗 生产产品过程中的消耗
 */
public class Waste extends BaseModel{
    //id
    private String id ;

    //损耗的商品id
    private String sId ;
    private Stock stock ;

    //损耗的商品重量 单位斤
    private Double weight ;

    //损耗创建日期
    @DateTimeFormat(pattern = DateUtil.DATETIME_FORMAT)
    private Date createTime ;

    private String createTimeStr ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        setCreateTimeStr(DateUtil.formatDateTime(createTime));
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
