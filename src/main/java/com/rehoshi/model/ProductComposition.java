package com.rehoshi.model;

/**
 * 产品组成原料
 */
public class ProductComposition extends BaseModel {
    //成分id
    private String id;
    //原品id
    private String sId;
    private Stock stock;
    //原品数量
    private Integer amount;
    //原品批次
    private String batch;

    //产品id
    private String pId;

    private Product product;

    //冗余成品数量
    private Integer pAmount;

    //规格允许用户修改
    private String specs;
    //规格单位
    private String specsUnit;
    //规格真正的值
    private Double specsValue;

    //待发货订单所需要的商品
    private String gId;
    private Goods goods;

    //所属订单
    private String oId;
    private Order order;

    //订单发货量
    private Double sendAmount ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getpAmount() {
        return pAmount;
    }

    public void setpAmount(Integer pAmount) {
        this.pAmount = pAmount;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getSpecsUnit() {
        return specsUnit;
    }

    public void setSpecsUnit(String specsUnit) {
        this.specsUnit = specsUnit;
    }

    public Double getSpecsValue() {
        return specsValue;
    }

    public void setSpecsValue(Double specsValue) {
        this.specsValue = specsValue;
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

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void judgeSpecsValue() {
        Double val;
        try {
            val = Double.valueOf(this.getSpecs());
        } catch (Exception e) {
            val = 1d;
        }
        setSpecsValue(val);
    }

    public Double getSendAmount() {
        if (sendAmount == null){
            sendAmount = 0d ;
        }
        return sendAmount;
    }

    public void setSendAmount(Double sendAmount) {
        this.sendAmount = sendAmount;
    }
}
