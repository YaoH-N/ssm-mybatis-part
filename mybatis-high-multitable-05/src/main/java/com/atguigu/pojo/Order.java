package com.atguigu.pojo;

import lombok.Data;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 10:53
 * Description:
 */
@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;

    // 一个订单对应一个客户 对一关系 Customer对象装对应的客户信息
    private Customer customer;
}
