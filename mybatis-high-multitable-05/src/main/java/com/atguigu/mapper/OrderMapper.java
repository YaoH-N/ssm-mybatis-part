package com.atguigu.mapper;

import com.atguigu.pojo.Order;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 10:55
 * Description: 订单方法
 */
public interface OrderMapper {
    // 根据id查询订单信息和订单对应的客户
    Order queryOrderById(Integer id);
}
