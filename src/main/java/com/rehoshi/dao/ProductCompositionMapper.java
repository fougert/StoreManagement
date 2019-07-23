package com.rehoshi.dao;

import com.rehoshi.model.ProductComposition;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductCompositionMapper {


    @Select("SELECT * FROM productcops WHERE pId = #{id}")
    @Results({
            @Result(column = "sId", property = "stock", one = @One(
                    select = "com.rehoshi.dao.StockMapper.getById"
            ))
    })
    List<ProductComposition> getByProductId(@Param("id") String id);

    @Delete("DELETE FROM productcops WHERE pId = #{id} ")
    int deleteByProductId(@Param("id") String id) ;

    @Delete({"<script>",
            "DELETE",
            "FROM `productcops`",
            "WHERE pId IN ",
            "<foreach collection = 'ids' item = 'id' open='(' separator = ',' close = ')' >",
            "#{id}",
            "</foreach>",
            "</script>"})
    int deleteByProductIdInIds(@Param("ids") List<String> ids) ;


    @Insert({"<script>",
            "INSERT INTO productcops(id, sId, amount, pId, batch) VALUES ",
            "<foreach collection='copsList' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.sId}, #{item.amount}, #{item.pId}, #{item.batch})",
            "</foreach>",
            "</script>"})
    int save(@Param("copsList") List<ProductComposition> productComposition);
}
