package io.drivesaf.springboot.file.utils;

import org.junit.jupiter.api.Test;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/31 17:00
 * @description: MinIoTemplateTest class for testing MinIoTemplate functionalities
 **/
@SpringBootTest
@Slf4j
class MinIoTemplateTest {
    @Resource
    private MinIoTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        // 判断是否有 avatar 这个存储桶存在
        boolean flag = minIoTemplate.bucketExists("avatar");
        log.info(String.valueOf(flag));
    }

    @Test
    void makeBucket() throws Exception {
        // 创建一个名为 mqxu 的存储桶
        minIoTemplate.makeBucket("mqxu");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:\\Users\\DRIVESAFE\\Desktop\\upload\\20241031\\e4345dba-8db9-4ee0-bc4c-bf206bb8549b.png");
        // 返回上传后的访问路径
        String url = minIoTemplate.putObject("mqxu", "test/" + UUID.randomUUID() + ".png", new FileInputStream(file));
        log.info(url);
    }

    @Test
    void removeObject() throws Exception {
        // 移除指定的文件（存在）
        minIoTemplate.removeObject("mqxu", "img/test.jpg");
    }
}
