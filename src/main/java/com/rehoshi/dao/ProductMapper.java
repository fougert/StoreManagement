package com.rehoshi.dao;

import com.rehoshi.dto.search.ProductPageSearch;
import com.rehoshi.model.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Select({"SELECT * FROM `product`",
            "WHERE name LIKE #{name}",
            "AND createTime BETWEEN #{startTime} AND #{endTime}",})
    List<Product> getBySearch(ProductPageSearch search);
}
