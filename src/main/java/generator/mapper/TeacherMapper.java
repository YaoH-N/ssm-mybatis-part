package generator.mapper;

import generator.com.atguigu.pojo.Teacher;

/**
* @author 24243
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2024-11-06 21:21:01
* @Entity generator.com.atguigu.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
