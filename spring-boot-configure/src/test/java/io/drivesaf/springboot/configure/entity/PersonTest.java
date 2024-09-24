package io.drivesaf.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 14:54
 * @description:
 **/
@SpringBootTest
class PersonTest {
    @Resource
    private Person person;

    @Test
    void test(){
        System.out.println(person);
    }

}