package io.drivesaf.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.mp.entity.Course;
import io.drivesaf.springboot.mp.entity.StudentCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:45
 * @description:
 **/
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(Long studentId);
}
