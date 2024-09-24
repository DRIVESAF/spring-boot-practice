package io.drivesaf.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 15:00
 * @description:
 **/
@SpringBootTest
class FamilyTest {
    @Resource
    private Family family;

    @Test
    void FamilyTest() {
        System.out.println(family);
    }

}