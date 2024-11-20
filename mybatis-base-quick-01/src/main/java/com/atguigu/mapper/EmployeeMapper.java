package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

/**
 * Author: 牛耀辉
 * Date: 2024/11/2 21:08
 * Description: 规定数据库方法即可
 */
public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    int deleteById(Integer id);
}
