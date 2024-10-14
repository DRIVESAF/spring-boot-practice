package io.drivesaf.springboot.mp.service;

import io.drivesaf.springboot.mp.entity.Student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 16:04
 * @description:
 **/
@SpringBootTest
@Slf4j
class StudentServiceTest {
    @Resource
    private StudentService studentService;
    @Test
    void getStudentWithCourses() {
        Student student = studentService.getStudentWithCourse(1L);
        log.info("{},{}", student.getId(), student.getName());
        student.getCourses().forEach(course -> log.info("{},{}", course.getId(), course.getName()));
    }
}
