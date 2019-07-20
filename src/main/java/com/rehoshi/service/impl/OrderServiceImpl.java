package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.OrderMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.OrderPageSearch;
import com.rehoshi.model.Order;
import com.rehoshi.service.OrderService;
import com.rehoshi.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public RespData<String> save(Order order) {
        RespData<String> data = RespData.fail("").setMsg("添加订单失败");
        order.newId();
        order.setCreateTime(new Date());
        int save = orderMapper.save(order);
        if(save > 0){
            data.success().setData(order.getId()).setMsg("添加订单成功") ;
        }
        return data;
    }

    @Override
    public RespData<Boolean> update(Order order) {
        RespData<Boolean> data = RespData.fail(false).setMsg("更新失败");
        if (DateUtil.getDiff(order.getCreateTime()) < 0) {
            data.setMsg("创建时间不能超过当前时间") ;
        } else {
            int update = orderMapper.update(order);
            if (update > 0) {
                data.success().setData(true).setMsg("更新成功");
            }
        }
        return data;
    }

    @Override
    public RespData<Boolean> send(String id) {
        return null;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        RespData<Boolean> data = RespData.fail(false).setMsg("删除订单失败");
        int i = orderMapper.deleteById(id);
        if (i > 0) {
            data.success().setData(true).setMsg("删除订单成功");
        }
        return data;
    }

    @Override
    public RespData<Boolean> deleteInIds(List<String> ids) {
        RespData<Boolean> data = RespData.fail(false).setMsg("批量删除订单失败") ;

        if(ids != null && !ids.isEmpty()){
            int i = orderMapper.deleteInIds(ids);
            if(i > 0){
                data.success().setData(true).setMsg("批量删除订单成功") ;
            }
        }else {
            data.setMsg("至少选择一条订单删除") ;
        }
        return data;
    }

    @Override
    public PageData<Order> orderInPage(OrderPageSearch search, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Order> bySearch = orderMapper.getBySearch(search);
        return new PageData<>(new PageInfo<>(bySearch));
    }

    @Override
    public RespData<Order> getById(String id) {
        return null;
    }
}
