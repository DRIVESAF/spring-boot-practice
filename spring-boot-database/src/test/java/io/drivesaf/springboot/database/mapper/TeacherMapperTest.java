package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Teacher;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 14:07
 * @description:
 **/
@SpringBootTest
@Slf4j
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void findTeacherById() {
        Teacher teacher = teacherMapper.findTeacherById(1);
        log.info(teacher.getTeacherName());
        log.info(teacher.getClazz().getClazzName());
    }
}