package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
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
 * Date: 2024/11/5 00:13
 * Description:
 */
public class MyBatisTest {

    private SqlSession sqlSession;
    private UserMapper mapper;

    @BeforeEach // 每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        // 1. 获取输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);  // 开启自动提交
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach // 每次走测试方法之后调用的方法！
    public void after() {
//        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsert() {
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("root");
        user.setUsername("root");
        int insert = mapper.insert(user);
        System.out.println("insert: " + insert);

    }

    @Test
    public void testUpdate() {
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setPassword("888888");
        user.setUsername("root");
        int update = mapper.update(user);
        System.out.println("update: " + update);
    }

    @Test
    public void testDelete() {
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete: " + delete);
    }

    @Test
    public void testSelectById() {
        User user = mapper.selectById(2);
        System.out.println("user = " + user);

    }

    @Test
    public void testSelectAll() {
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
