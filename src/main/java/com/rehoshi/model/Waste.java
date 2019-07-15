package com.rehoshi.model;

/**
 * 损耗 生产产品过程中的消耗
 */
public class Waste extends BaseModel{
    //id
    private String id ;

    //损耗的商品id
    private String gId ;
    private Goods goods ;

    //损耗的商品重量 单位斤
    private Double weight ;

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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
