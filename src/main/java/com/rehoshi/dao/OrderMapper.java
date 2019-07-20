package com.rehoshi.dao;

import com.rehoshi.dto.search.OrderPageSearch;
import com.rehoshi.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {


    /**
     * 根据条件查找订单
     *
     * @param search 查询条件
     * @return
     */
    @Select({"<script>",
            "SELECT * FROM `order`",
            "WHERE name LIKE #{name}",
            "AND createTime BETWEEN #{startTime} AND #{endTime}",
            "<when test = 'status != null'>",
            "AND status = #{status}",
            "</when>",
            "</script>"})
    List<Order> getBySearch(OrderPageSearch search);

    /**
     * 根据ID删除订单
     *
     * @param id
     */
    @Delete("DELETE FROM `order` WHERE id = #{id}")
    int deleteById(String id);

    /**
     * 根据id更新订单
     *
     * @param order 需要更新的订单信息
     * @return
     */
    @Update("UPDATE `order` SET name = #{name}, serial = #{serial}, " +
            "sId = #{sId}, amount = #{amount}, " +
            "createTime = #{createTime}, status = #{status} WHERE id = #{id}")
    int update(Order order);

    /**
     * 添加订单
     *
     * @param order 需要添加的订单信息
     * @return
     */
    @Insert("INSERT INTO `order` (id, name, serial, sId, amount, createTime, status) " +
            "VALUES (#{id}, #{name}, #{serial}, #{sId}, #{amount}, #{createTime}, #{status})")
    int save(Order order);

    /**
     * 批量删除订单
     *
     * @param ids
     * @return
     */
    @Delete({"<script>",
            "DELETE",
            "FROM `order`",
            "WHERE id IN ",
            "<foreach collection = 'ids' item = 'id' open='(' separator = ',' close = ')' >",
            "#{id}",
            "</foreach>",
            "</script>"})
    int deleteInIds(@Param("ids") List<String> ids);
}
