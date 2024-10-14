package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Course;
import io.drivesaf.springboot.database.entity.Student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 15:35
 * @description:
 **/
@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;
    @Test
    void selectAll() {
        List<Course> courses = courseMapper.selectAll();
        courses.forEach(course -> {
            log.info("{}", course.getCourseName());
            List<Student> students = course.getStudents();
            students.forEach(student -> log.info("{},{}", student.getStudentName(), student.getHometown()));
        });
    }
}