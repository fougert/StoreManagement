package com.rehoshi.model;

import com.rehoshi.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单
 */
public class Order extends BaseModel{

    /**
     * 订单状态
     */
    public interface Status{
        //待发货
        int WAIT_SEND = 0 ;
        //已发货
        int HAS_SENT = 1 ;
    }
    //订单ID
    private String id ;

    //订单编号
    private String serial ;

    //订单名称
    private String name ;

    //库存商品id
    private String pId ;

    //成品
    private Product product ;

    //订单数量
    private Integer amount ;

    //状态
    private Integer status ;

    //创建时间
    @DateTimeFormat(pattern = DateUtil.DATETIME_FORMAT)
    private Date createTime ;
    private String createTimeStr;

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
        setCreateTimeStr(DateUtil.formatDateTime(createTime));
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
