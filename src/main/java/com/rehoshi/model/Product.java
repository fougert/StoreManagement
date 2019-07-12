package com.rehoshi.model;

import java.util.Date;
import java.util.List;

/**
 * 产品 将原品打包之后的
 * 使用原料包材 将原品打包好
 */
public class Product {

    //产品id
    private String id ;

    //产品的名称
    private String name ;

    //产品的成分
    private List<ProductComposition> compositions ;

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

    public List<ProductComposition> getCompositions() {
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
    }
}
