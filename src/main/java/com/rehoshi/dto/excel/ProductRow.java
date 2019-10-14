package com.rehoshi.dto.excel;

import com.rehoshi.model.Product;

public class ProductRow  extends ExcelRow<Product>{
    public ProductRow(Product model) {
        super(model);
    }
}
