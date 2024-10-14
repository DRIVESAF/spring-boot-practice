package io.drivesaf.springboot.mp.service;

import io.drivesaf.springboot.mp.entity.Course;
import io.drivesaf.springboot.mp.entity.Student;
import io.drivesaf.springboot.mp.mapper.StudentCourseMapper;
import io.drivesaf.springboot.mp.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:51
 * @description:
 **/
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;

    public Student getStudentWithCourse(Long studentId){
        Student student = studentMapper.selectById(studentId);
        if (student != null){
            List<Course> courses =studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}
