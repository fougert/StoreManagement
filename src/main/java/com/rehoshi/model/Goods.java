package com.rehoshi.model;

/**
 * 物品类 包含
 * 商品 原料 包材
 */
public class Goods extends BaseModel{

    interface Type{
        int GOODS = 0 ;
        int MATERIAL = 1 ;
        int PACKAGE_MATERIAL = 2 ;
    }

    //id
    private String id ;
    //名称
    private String name ;

    //类型 默认商品类型
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


    public Integer getType() {
        if(type == null){
            type = Type.GOODS ;
        }
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
