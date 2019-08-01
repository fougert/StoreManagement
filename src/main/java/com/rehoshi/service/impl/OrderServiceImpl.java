package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.OrderMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.dto.search.OrderPageSearch;
import com.rehoshi.model.Order;
import com.rehoshi.service.OrderService;
import com.rehoshi.util.CollectionUtil;
import com.rehoshi.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public RespData<String> save(Order order) {
        RespData<String> data = RespData.fail("").setMsg("添加订单失败");
        if (order == null) {
            data.setMsg("请输入订单信息");
        } else if (CollectionUtil.isNullOrEmpty(order.getSubOrders())) {
            data.setMsg("请选择成品");
        } else {
            order.newId();
            order.setCreateTime(new Date());
            order.newChildren() ;
            int i = orderMapper.saveAll(order.getSubOrders());
            if (i > 0) {
                int save = orderMapper.save(order);
                if (save > 0) {
                    data.success().setData(order.getId()).setMsg("添加订单成功");
                }
            } else {
                data.setMsg("添加子订单失败");
            }
        }
        return data;
    }

    @Override
    public RespData<Boolean> update(Order order) {
        RespData<Boolean> data = RespData.fail(false).setMsg("更新失败");
        if (DateUtil.getDiff(order.getCreateTime()) < 0) {
            data.setMsg("创建时间不能超过当前时间");
        } else {
            //先删除之前的关系
            orderMapper.deleteByParentId(order.getId());
            int update = orderMapper.update(order);
            if (update > 0) {
                //重新保存关系
                order.newChildren() ;
                orderMapper.saveAll(order.getSubOrders()) ;
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
            //删除关系
            orderMapper.deleteByParentId(id) ;
            data.success().setData(true).setMsg("删除订单成功");
        }
        return data;
    }

    @Override
    public RespData<Boolean> deleteInIds(List<String> ids) {
        RespData<Boolean> data = RespData.fail(false).setMsg("批量删除订单失败");

        if (ids != null && !ids.isEmpty()) {
            int i = orderMapper.deleteInIds(ids);
            if (i > 0) {
                //批量删除子订单关系
                orderMapper.deleteInParentIds(ids) ;
                data.success().setData(true).setMsg("批量删除订单成功");
            }
        } else {
            data.setMsg("至少选择一条订单删除");
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
        RespData<Order> data = new RespData<Order>().setData(null).setMsg("查询订单失败");
        Order byId = orderMapper.getById(id);
        if (byId != null) {
            byId.setSubOrders(orderMapper.getByParentId(byId.getId()));
            data.success().setData(byId).setMsg("查询订单成功");
        }
        return data;
    }
}
