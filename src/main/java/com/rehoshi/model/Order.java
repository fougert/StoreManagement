package com.rehoshi.model;

import java.util.Date;

/**
 * 订单
 */
public class Order {

    /**
     * 订单状态
     */
    public interface Status{
        //待发货
        int WAIT_SEND = 0 ;
        //已发货
        int HAS_SENT = 0 ;
    }
    //订单ID
    private String id ;
    //订单名称
    private String name ;
    //库存商品id
    private String sId ;
    //商品
    private Stock stock ;

    //订单数量
    private Integer amount ;
    //状态
    private Integer status ;

    //创建时间
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}
