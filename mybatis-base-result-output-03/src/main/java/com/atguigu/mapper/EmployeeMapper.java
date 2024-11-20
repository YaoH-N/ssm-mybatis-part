package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Author: 牛耀辉
 * Date: 2024/11/3 10:49
 * Description:
 */
public interface EmployeeMapper {

    // 如果是dml语句 （插入 修改 删除）
    int deleteById(Integer id);

    // 指定输出类型 查询语句
    // 根据员工的id查询员工的姓名
    String queryNameById(Integer id);

    // 根据员工的id查询员工的工资
    Double querySalaryById(Integer id);

    // 根据id查询员工对象  返回单个自定义的实体类型
    Employee queryById(Integer id);

    /**
     * 查询部门的最高工资和平均工资
     * @return
     */
    Map<String, Object> selectEmpNameAndMaxSalary();

    // 查询工资高于传入值的员工姓名们 200
    List<String> queryNameBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

    // 员工插入
    int insertEmp(Employee employee);
}
