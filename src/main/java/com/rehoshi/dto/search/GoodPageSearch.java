package com.rehoshi.dto.search;

/**
 * 封装商品查询参数
 */
public class GoodPageSearch {

    private Integer type;

    private String name;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public String getName() {
        if (name==null){
            return "%%";
        }
      return "%"+name+"%";
    }

    public void setName(String name) {
        this.name = name;
    }
}
