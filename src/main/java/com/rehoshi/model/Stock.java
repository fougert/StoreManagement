package com.rehoshi.model;

import com.rehoshi.util.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 货物 主要存原品的数量信息
 */
@Data
public class Stock extends BaseModel {
    //货品名称
    private String name;
    //货品图片
//    private String img ;
    //货品种类
    private String gId;
    //商品
    private Goods goods;
    //货品规格
    //private Double specs;
    //货品数量
    private Integer amount;
    //误差数量
    private Double offsetAmount;
    //货品价格
    private Double price;
    //货品批次 使用当前时间字符串 精确到分钟  yyyy-MM-dd HH:mm
    private String batch;
    //供应商id
    private String supplierId ;
    //供应商 缓存的名称
    private String provider;
    //描述
    private String description;
    //入库时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //发货量
    private Double sendAmount;
    //损耗数量
    private Double wasteAmount;
    //生产数量
    private Double productAmount;

    private String createTimeStr;
    //剩余数量
    private Double remainAmount;
    //冗余的规格值
    private Double specsValue;

    public Integer getAmount() {
        if (amount == null) {
            amount = 0;
        }
        return amount;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        setCreateTimeStr(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", createTime));
    }


    public Double getSendAmount() {
        if (sendAmount == null) {
            sendAmount = 0d;
        }
        return sendAmount;
    }


    public Double getWasteAmount() {
        if (wasteAmount == null) {
            wasteAmount = 0d;
        }
        return wasteAmount;
    }


    public Double getProductAmount() {
        if (productAmount == null) {
            productAmount = 0d;
        }
        return productAmount;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public Double getOffsetAmount() {
        if (offsetAmount == null) {
            offsetAmount = 0d;
        }
        return offsetAmount;
    }

    //    d.amount * d.goods.specsValue - d.productAmount - d.wasteAmount + d.offsetAmount
    public Double getRemainAmount() {
        if (this.remainAmount == null) {
            this.remainAmount = getAmount() * getSpecsValue() - getProductAmount() - getWasteAmount() + getOffsetAmount();
        }
        return this.remainAmount;
    }

    public Double getSpecsValue() {
        if (specsValue == null) {
            specsValue = 1d;
        }
        return specsValue;
    }
}
