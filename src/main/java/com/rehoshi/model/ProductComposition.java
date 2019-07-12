package com.rehoshi.model;

/**
 * 产品组成原料
 */
public class ProductComposition {
    //成分id
    private String id ;
    //原品id
    private String gId ;
    private Stock stock ;
    //原品规格
    private Double specs ;
    //原品数量
    private Integer amounnt ;
    //原品批次
    private String batch ;

    //产品id
    private String pId ;
    private Product product ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Double getSpecs() {
        return specs;
    }

    public void setSpecs(Double specs) {
        this.specs = specs;
    }

    public Integer getAmounnt() {
        return amounnt;
    }

    public void setAmounnt(Integer amounnt) {
        this.amounnt = amounnt;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
