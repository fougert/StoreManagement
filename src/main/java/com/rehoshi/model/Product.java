package com.rehoshi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rehoshi.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品 将原品打包之后的
 * 使用原料包材 将原品打包好
 */
public class Product extends BaseModel {

    //产品id
    private String id;

    //产品的名称
    private String name;

    //产品的成分
    private List<ProductComposition> compositions;

    //创建时间
    @DateTimeFormat(pattern = DateUtil.DATETIME_FORMAT)
    @JsonFormat(pattern = DateUtil.DATETIME_FORMAT, timezone = "GMT+8")
    private Date createTime;
    private String createTimeStr;

    private Double specs ;

    //打包费用
    private Double packFee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductComposition> getCompositions() {
        if (compositions == null) {
            compositions = new ArrayList<>();
        }
        return compositions;
    }

    public void setCompositions(List<ProductComposition> compositions) {
        this.compositions = compositions;
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

    public Double getSpecs() {
        return specs;
    }

    public void setSpecs(Double specs) {
        this.specs = specs;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }
}
