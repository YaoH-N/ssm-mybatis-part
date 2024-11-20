package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: 牛耀辉
 * Date: 2024/11/2 21:19
 * Description:
 */
public class MybatisTest {

    /**
     * mybatis提供的api进行方法的调用
     * jdbcTemplate  new  JdbcTemplate -> 使用
     */
    @Test
    public void test_01() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.queryById(1);

        System.out.println("employee = " + employee);

        // 4.关闭SqlSession
        session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话
    }

    @Test
    public void test_02() throws IOException {
// 1.创建SqlSessionFactory对象
        // 1.声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // 以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // 2.基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3.使用SqlSessionFactory对象开启一个会话
        SqlSession sqlSession = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)  jdk动态代理技术生成的mapper代理对象
         EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句  拼接类的全限定符.方法名   整合参数  ->  最后调用ibatis对应的方法传入参数
        //mybatis底层依然是调用ibatis只不过有固定的模式！
         Employee employee = employeeMapper.queryById(1);
         System.out.println("employee = " + employee);

        //4. sqlSession提供的curd方法进行数据库查询即可
        // selectOne selectList / insert / delete / update  查找对应的sql语句的标签，mybatis再执行！
        // 参数1： 字符串  sql标签对应的标识 id | namespace.id  参数2： Object  执行sql语句传入的参数
//        Student student = sqlSession.selectOne("xx.jj.kkk", 1);
        //缺点：1. sql语句标签对应的字符串标识，容易出现错误；  2. 参数需要进行整合，只能传递一个！ 3. 返回值问题！
//        System.out.println("student=" + student);


        // 5.关闭SqlSession
        sqlSession.commit(); //提交事务 [DQL不需要,其他需要]
        sqlSession.close(); //关闭会话
    }
}
