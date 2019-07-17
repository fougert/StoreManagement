package com.rehoshi.dao;


import com.rehoshi.dto.RespData;
import com.rehoshi.model.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface GoodsMapper {



    @Select("SELECT * FROM GOODS")
    List<Goods> getAllGoods();


    @Select("SELECT * FROM GOODS WHERE name=#{name}")
    List<Goods> queryByName(@Param("name") String name);



    @Insert("INSERT INTO goods VALUES (#{uuid},#{name},#{type})")
    int addGoodsType(@Param("uuid") String uuid, @Param("name") String name, @Param("type") Integer type);


    @Select("SELECT * FROM GOODS WHERE name=#{name} AND type=#{type}")
    List<Goods> queryByNameAndType(@Param("name") String name, @Param("type") Integer type);

    @Delete("DELETE FROM goods WHERE id=#{id}")
    int delGoodsType(@Param("id") String id);


    @Update("UPDATE goods SET name = #{name},type = #{type} WHERE id = #{id}")
    int editGoods(Goods good);

    /*
        DELETE FROM goods WHERE id in ('','')
     */
    @Delete({
    "<script>"
            + "DELETE FROM goods  WHERE id in "
            + "<foreach item='item' index='index' collection='goodslist' open='(' separator=',' close=')'>"
            +       "#{item.id}"
            + "</foreach>"
            +"</script>"
    })
    int delBatchGoodTypes(@Param("goodslist") List<Goods> goodslist);
}
