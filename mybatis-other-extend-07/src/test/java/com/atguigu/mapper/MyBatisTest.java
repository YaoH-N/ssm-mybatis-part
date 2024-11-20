package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
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
 * Date: 2024/11/6 20:02
 * Description:
 */
public class MyBatisTest {
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;

    @BeforeEach // 每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        // 1. 获取输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);  // 开启自动提交
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @AfterEach // 每次走测试方法之后调用的方法！
    public void after() {
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_01() {

        // 调用之前，先设置分页数据（当前是第几页，每页显示多少个！）
        PageHelper.startPage(2, 2);

        //TODO: 注意：不能将两条查询装到一个分页区
        List<Employee> list = employeeMapper.queryList();

        // 将查询数据封装到一个PageInfo的分页实体类中（一共有多少页，一共有多少条等等）
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        // pageInfo获取分页的数据

        // 获取当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        // 获取总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        // 获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        //获取当前是第几页
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize(); // 获取页容量
        System.out.println("pageSize = " + pageSize);
    }

}
