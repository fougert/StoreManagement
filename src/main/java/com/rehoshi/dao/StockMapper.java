package com.rehoshi.dao;


import com.rehoshi.model.Stock;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StockMapper {


    @Select("SELECT * FROM stock")
    List<Stock> getAllStock();

    @Delete("DELETE FROM stock WHERE id = #{id}")
    int delByID(@Param("id") String id);

    @Insert("INSERT INTO stock VALUES (#{id},#{name},#{img},#{gId},#{specs},#{amount},#{price},#{batch},#{provider},#{description},#{createTime})")
    int addStock(Stock stock);


    @Delete({
            "<script>"
                    + "DELETE FROM stock  WHERE id in "
                    + "<foreach item='item' index='index' collection='stockList' open='(' separator=',' close=')'>"
                    +       "#{item.id}"
                    + "</foreach>"
                    +"</script>"
    })
    int delBatchStock(@Param("stockList") List<Stock> stockList);
}
