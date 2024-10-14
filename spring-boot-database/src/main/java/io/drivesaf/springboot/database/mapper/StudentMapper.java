package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 19:31
 * @description:
 **/
public interface StudentMapper {
    int insert (Student student);

    Student findStudentById(int studentId);

    int updateById(Student student);

    int deleteById(int studentId);

    int batchInsert(@Param("students") List<Student> students);

    int batchDelete(@Param("idList") List<Integer> ids);

    List<Student> selectByDynamicSql(Student student);

    // 批量更新
    int batchupdate(Student student);

    Student getStudentManyToOne(int studentId);

    Student getStudent(int studentId);
}
