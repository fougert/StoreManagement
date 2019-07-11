package com.rehoshi.model;

/**
 * 订单
 */
public class Order {
    public interface Status{
        int WAIT_SEND = 0 ;
        int HAS_SENT = 0 ;
    }
    //订单ID
    private String id ;
    //订单名称
    private String name ;
    //订单规格
    private String specs ;
    //订单数量
    private Integer amount ;
    //状态
    private Integer status ;

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

    public Integer getStatus() {
        return status == null ? Status.WAIT_SEND : status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
