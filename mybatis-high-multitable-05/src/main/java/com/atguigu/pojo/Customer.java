package com.atguigu.pojo;

import lombok.Data;

import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 10:52
 * Description: 客户实体类
 */
@Data  // 加入getter和setter和toString方法
public class Customer {
    private Integer customerId;
    private String customerName;

    // 一个客户对应多个订单  对多：装对方类型的集合即可
    private List<Order> orderList;

}
