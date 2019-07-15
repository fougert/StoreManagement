package com.rehoshi.dao;


import com.rehoshi.model.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface GoodsMapper {


    @Select("select * from goods")
    List<Goods> getAllGoods();

}
