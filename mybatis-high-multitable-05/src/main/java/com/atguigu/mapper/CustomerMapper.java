package com.atguigu.mapper;

import com.atguigu.pojo.Customer;

import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 11:17
 * Description: 客户的方法
 */
public interface CustomerMapper {

    // 查询所有客户信息以及客户对应的订单信息
    List<Customer> queryList();
}
