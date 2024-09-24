package io.drivesaf.springboot.configure.entity;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 17:49
 * @description:
 **/
@SpringBootTest
@Slf4j
class StudentTest {
    @Resource
    private Dog dog;
    @Resource
    private Student student;
    @Test
    void testStudent() {
        log.info(String.valueOf(dog));
        log.info(String.valueOf(student));
    }
}