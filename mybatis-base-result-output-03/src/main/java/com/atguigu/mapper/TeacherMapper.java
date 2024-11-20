package com.atguigu.mapper;

import com.atguigu.pojo.Teacher;

/**
 * Author: 牛耀辉
 * Date: 2024/11/4 23:09
 * Description:
 */
public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher queryById(String id);
}
