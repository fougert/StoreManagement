package com.rehoshi.model;

/**
 * 物品类 包含
 * 商品 原料 包材
 */
public class Goods extends BaseModel {

    interface Type {
        int GOODS = 0;
        int MATERIAL = 1;
        int PACKAGE_MATERIAL = 2;
    }

    //id
    private String id;
    //名称
    private String name;

    //类型 默认商品类型
    private Integer type;

    //商品规格 标签用于显示
    private String specs;

    //商品规格单位
    private String specsUnit;

    //img  保存图片相对地址
    private String img;

    //商品真正的规格
    private Double specsValue ;

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
        if (type == null) {
            type = Type.GOODS;
        }
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public void judgeSpecsValue(){
        Double val ;
        try {
            val = Double.valueOf(this.getSpecs()) ;
        }catch (Exception e){
            val = 1d ;
        }
        setSpecsValue(val);
    }
}
