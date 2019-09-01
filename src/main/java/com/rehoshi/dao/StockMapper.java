package com.rehoshi.dao;


import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.model.Stock;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StockMapper {


    @Select("SELECT * FROM stock")
    List<Stock> getAllStock();

    @Select("SELECT *," +
            "(SELECT SUM(weight) FROM waste WHERE sId = s.id) " +
            "FROM stock s WHERE id = #{id}")
    @Results({
            @Result(column = "gId", property = "goods", one = @One(
                    select = "com.rehoshi.dao.GoodsMapper.queryGoodSByID"
            ))
    })
    Stock getById(@Param("id") String id);

    @Delete("DELETE FROM stock WHERE id = #{id}")
    int delByID(@Param("id") String id);

    @Insert("INSERT INTO stock VALUES (#{id},#{name},#{gId},#{amount},#{price},#{batch},#{provider},#{description},#{createTime})")
    int addStock(Stock stock);


    /**
     * 批量删除
     *
     * @param stockList
     * @return
     */
    @Delete({
            "<script>"
                    + "DELETE FROM stock  WHERE id in "
                    + "<foreach item='item' index='index' collection='stockList' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int delBatchStock(@Param("stockList") List<Stock> stockList);


    @Select({"<script>",
            "SELECT *, ",
            "(SELECT SUM(weight) FROM waste WHERE sId = s.id)",
            " FROM `stock` s",
            "WHERE name LIKE #{name}",
            "AND createTime BETWEEN #{startTime} AND #{endTime}",
            "</script>"})
    @Results({
            @Result(column = "gId", property = "goods", one = @One(
                    select = "com.rehoshi.dao.GoodsMapper.queryGoodSByID"
            ))
    })
    List<Stock> queryStockBySearch(StockPageSearch search);

    @Update("UPDATE stock SET name=#{name},gId=#{gId},amount=#{amount},price=#{price},provider=#{provider},description=#{description} WHERE id=#{id}")
    int editStock(Stock stock);
}
