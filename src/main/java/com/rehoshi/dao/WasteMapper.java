package com.rehoshi.dao;

import com.rehoshi.dto.search.WastePageSearch;
import com.rehoshi.model.Waste;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WasteMapper {

    /**
     * 查询损耗列表
     *
     * @param search
     * @return
     */
    @Select("SELECT * FROM waste ORDER BY createTime DESC")
    @Results({
            @Result(column = "sId", property = "stock",
                    one = @One(select = "com.rehoshi.dao.StockMapper.getById"))
    })
    List<Waste> getBySearch(WastePageSearch search);

    /**
     * 根据ID 查找 损耗
     * @param id 损耗id
     * @return
     */
    @Select("SELECT * FROM waste WHERE id = #{id}")
    @Results({
            @Result(column = "sId", property = "stock",
                    one = @One(select = "com.rehoshi.dao.StockMapper.getById"))
    })
    Waste getById(@Param("id") String id);

    @Insert("INSERT INTO waste (id, sId, weight, createTime) VALUES (#{id}, #{sId}, #{weight}, #{createTime})")
    int save(Waste waste);

    @Update("UPDATE waste SET sId = #{sId}, weight = #{weight}, createTime = #{createTime} WHERE id = #{id}")
    int update(Waste waste);

    @Delete("DELETE FROM waste WHERE id = #{id}")
    int deleteById(String id);

    @Delete({
            "<script>",
            "DELETE FROM waste",
            "WHERE id IN",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    int deleteInIds(@Param("ids") List<String> ids);

}
