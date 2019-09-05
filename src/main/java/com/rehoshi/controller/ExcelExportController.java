package com.rehoshi.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.excel.*;
import com.rehoshi.dto.search.OrderPageSearch;
import com.rehoshi.dto.search.ProductPageSearch;
import com.rehoshi.dto.search.StockPageSearch;
import com.rehoshi.dto.search.WastePageSearch;
import com.rehoshi.model.*;
import com.rehoshi.service.OrderService;
import com.rehoshi.service.ProductService;
import com.rehoshi.service.StockService;
import com.rehoshi.service.WasteService;
import com.rehoshi.util.CollectionUtil;
import com.rehoshi.util.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("excel/export")
public class ExcelExportController extends BaseExcelController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WasteService wasteService;

    @Autowired
    private StockService stockService;

    @Autowired
    private ProductService productService;

    @GetMapping("stock")
    public void stock(@RequestParam(required = false) String name,
                      @RequestParam(value = "startTime", required = false) String startTimeStr,
                      @RequestParam(value = "endTime", required = false) String endTimeStr) {
        Date startTime = DateUtil.toDate(startTimeStr);
        Date endTime = DateUtil.toDate(endTimeStr);

        if (endTime != null) {
            endTime = DateUtil.addTime(endTime, 1, DateUtil.Unit.DAY);
        }

        StockPageSearch search = new StockPageSearch();
        search.setName(name);
        search.setStartTime(startTime);
        search.setEndTime(endTime);
        RespData<List<Stock>> listRespData = stockService.list(search);
        export(StockRow.class, CollectionUtil.map(listRespData.data, StockRow::new), "库存");
    }

    @GetMapping("product/waste")
    public void productWaste(@RequestParam(value = "name", required = false) String name) {
        WastePageSearch search = new WastePageSearch();
        search.setName(name);
        RespData<List<Waste>> list = wasteService.list(search);
        export(WasteRow.class, CollectionUtil.map(list.data, WasteRow::new), "生产-损耗");
    }

    @GetMapping("product")
    public void product(@RequestParam(required = false) String name,
                        @RequestParam(value = "startTime", required = false) String startTimeStr,
                        @RequestParam(value = "endTime", required = false) String endTimeStr) {
        ProductPageSearch search = new ProductPageSearch();
        search.setName(name);
        search.setStartTime(DateUtil.toDate(startTimeStr));
        search.setEndTime(DateUtil.addTime(DateUtil.toDate(endTimeStr), 1, DateUtil.Unit.DAY));
        RespData<List<Product>> listRespData = productService.list(search);
        List<ProductCopsRow> copsRowList = new ArrayList<>();
        List<ExcelMergeInfo> mergeInfos = new ArrayList<>();
        CollectionUtil.foreach(listRespData.data, (data, index) -> {
            int startRow = 1 + copsRowList.size();
            CollectionUtil.foreach(data.getCompositions(), cops -> {
                copsRowList.add(new ProductCopsRow(data, cops));
            });
            int endRow = 1 + copsRowList.size();
            if (endRow - startRow > 1) {
                for (int i = 0; i < 5; i++) {
                    ExcelMergeInfo mergeInfo = new ExcelMergeInfo();
                    mergeInfo.setStartRow(startRow);
                    mergeInfo.setEndRow(endRow - 1);
                    mergeInfo.setStartCol(i);
                    mergeInfo.setEndCol(i);
                    mergeInfos.add(mergeInfo);
                }
            }
        });
        export(ProductCopsRow.class, copsRowList, "生产-生产", mergeInfos);
    }

    @GetMapping("order")
    public void orderList(@RequestParam(value = "startTime", required = false) String startTime,
                          @RequestParam(value = "endTime", required = false) String endTime,
                          @RequestParam(value = "status", required = false) Integer status,
                          @RequestParam(value = "name", required = false) String name, HttpServletResponse response) {
        Date startDate = DateUtil.toDate(startTime);

        Date endDate = DateUtil.toDate(endTime);

        if (endDate != null) {
            endDate = DateUtil.addTime(endDate, 1, DateUtil.Unit.DAY);
        }
        OrderPageSearch search = new OrderPageSearch();
        search.setName(name);
        search.setStartTime(startDate);
        search.setEndTime(endDate);
        search.setStatus(status);
        RespData<List<Order>> listRespData = orderService.orderList(search);
        String statusStr = "";
        if (status == null || status == Order.Status.WAIT_SEND) {
            statusStr = "待发货";
        } else {
            statusStr = "已发货";
        }
        export(OrderRow.class, CollectionUtil.map(listRespData.data, OrderRow::new), "订单-" + statusStr);
    }

}
