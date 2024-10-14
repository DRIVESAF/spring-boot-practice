package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Course;
import io.drivesaf.springboot.database.entity.Student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 19:42
 * @description:
 **/
@SpringBootTest
@Slf4j
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                .birthday(LocalDate.now())
                .build();
        int n = studentMapper.insert(student);
        assertEquals(1,n);
    }

    @Test
    void findStudentById() {
        Student student = studentMapper.findStudentById(1001);
        assertEquals("新的名字",student.getStudentName());
    }

    @Test
    void updateById() {
        Student student = Student.builder().studentId(1001).studentName("钱智康").build();
        int n = studentMapper.updateById(student);
        assertEquals(1,n);
    }

    @Test
    void deleteById() {
        int n = studentMapper.deleteById(8011);
        assertEquals(1,n);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(6000+i)
                    .clazzId(1)
                    .studentName("测试学生" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(10,n);
    }


    @Test
    void batchDelete() {
        List<Integer> idList = List.of(6000,6001,6002);
        int n = studentMapper.batchDelete(idList);
        assertEquals(3,n);
    }

    @Test
    void selectByDynamicSql() {
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }

    @Test
    void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student student = Student.builder()
                    .studentId(8003 + i)
                    .studentName("更新学生" + i)
                    .clazzId(2)
                    .hometown("上海")
                    .birthday(LocalDate.now().minusYears(5))
                    .build();
            students.add(student);
        }

        // 逐个更新学生信息
        for (Student student : students) {
            studentMapper.batchupdate(student);
        }

        // 输出更新完成的学生数量
        System.out.println("批量更新完成，共更新了 " + students.size() + " 条记录");
    }

    @Test
    void getStudentManyToOne(){
        Student student = studentMapper.getStudentManyToOne(1001);
        log.info("{},{},{}",student.getStudentName(),student.getHometown(),student.getClazz().getClazzName());
    }

    @Test
    void getStudent(){
        Student student = studentMapper.getStudent(1001);
        log.info("{},{}",student.getStudentName(),student.getHometown());
        log.info("{}",student.getClazz().getClazzName());
        List<Course> courses = student.getCourses();
        courses.forEach(course -> log.info("{},{}",course.getCourseId(),course.getCourseName()));
    }
}