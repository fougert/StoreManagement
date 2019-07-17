package com.rehoshi.dao;


import com.rehoshi.model.Stock;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StockMapper {


    @Select("SELECT * FROM stock")
    List<Stock> getAllStock();
}
