package com.rehoshi.model;

import java.util.Date;

/**
 * 货物 主要存原品的数量信息
 */
public class Stock extends BaseModel{

    //货品ID
    private String id ;
    //货品名称
    private String name ;
    //货品图片
    private String img ;
    //货品规格
    private String gId ;
    //货品数量
    private Integer amount ;
    //货品价格
    private Double price ;
    //货品批次 使用当前时间字符串 精确到分钟  yyyy-MM-dd HH:mm
    private String batch ;
    //供应商
    private String provider ;
    //描述
    private String description ;
    //入库时间
    private Date createTime ;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public Integer getAmount() {
        if(amount == null){
            amount = 0 ;
        }
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
