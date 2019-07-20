package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.search.ProductPageSearch;
import com.rehoshi.model.Product;
import com.rehoshi.service.ProductService;
import com.rehoshi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("product")
@Controller
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public PageData<Product> listInPage(@RequestParam(required = false) String name,
                                        @RequestParam(value = "startTime",required = false) String startTimeStr,
                                        @RequestParam(value = "endTime",required = false) String endTimeStr,
                                        @RequestParam("page") int pageIndex,
                                        @RequestParam("limit") int pageSize) {

        ProductPageSearch search = new ProductPageSearch() ;
        search.setName(name);
        search.setStartTime(DateUtil.toDate(startTimeStr));
        search.setEndTime(DateUtil.addTime(DateUtil.toDate(endTimeStr), 1, DateUtil.Unit.DAY));

        return productService.productInPage(search, pageIndex, pageSize) ;
    }

}
