package com.rehoshi.model;

/**
 * 货品 包含了 商品 原料 包材
 */
public class Stock {

    public interface Type{
        //商品
        int GOODS = 0 ;
        //原料
        int MATERIAL = 1 ;
        //包材
        int PACKAGE_MATERIAL = 2 ;
    }

    //货品ID
    private String id ;
    //货品名称
    private String name ;
    //货品图片
    private String img ;
    //货品规格
    private String specs ;
    //货品数量
    private Integer amount ;
    //货品价格
    private Double price ;
    //货品批次
    private Integer batch ;
    //供应商
    private String provider ;
    //类型
    private Integer type ;

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

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public Integer getAmount() {
        return amount == null ? 0 : amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price == null ? 0 : price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
