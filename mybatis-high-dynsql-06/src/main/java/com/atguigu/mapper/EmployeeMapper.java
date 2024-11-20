package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/11/6 15:07
 * Description: 定义员工的数据操作方法
 */
public interface EmployeeMapper {

    // 根据员工的姓名和工资查询员工的信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工的姓名和工资查询员工的信息  Trim 标签
    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工id更新员工的数据，我么要求传入的name和salary不为null时才更新
    int updata(Employee employee);

    int updataTrim(Employee employee);


    // 根据两个条件查询，如果姓名不为null使用姓名查询，如果姓名为null，薪水不为null 使用薪水查询！ 都为null查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id批量删除
    int deleteBath(@Param("ids") List<Integer> ids);

    //根据id批量添加
    int insertBatch(@Param("employees") List<Employee> employees);

    //根据id批量修改
    int updateBatch(@Param("employees") List<Employee> employees);

}
