package com.atguigu.test;

import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 11:11
 * Description:
 */
public class MybatisTest {
    private SqlSession sqlSession;
    private OrderMapper orderMapper;
    private CustomerMapper customerMapper;

    @BeforeEach // 每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        // 1. 获取输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);  // 开启自动提交
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        customerMapper = sqlSession.getMapper(CustomerMapper.class);
    }

    @AfterEach // 每次走测试方法之后调用的方法！
    public void after() {
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryOrderById() {
        Order order = orderMapper.queryOrderById(1);
        System.out.println("order = " + order);
    }

    @Test
    public void queryList() {
        List<Customer> customerList = customerMapper.queryList();
        System.out.println("customerList = " + customerList);
    }


}
