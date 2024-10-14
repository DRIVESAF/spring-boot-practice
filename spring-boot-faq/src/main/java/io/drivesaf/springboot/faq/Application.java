package io.drivesaf.springboot.faq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 14:18
 * @description:
 **/

// @MapperScan(basePackages = {"io.drivesaf.springboot.faq.mapper"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

