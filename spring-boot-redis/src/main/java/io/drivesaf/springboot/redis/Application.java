package io.drivesaf.springboot.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 13:48
 * @description:
 **/

@MapperScan(basePackages = {"io.drivesaf.springboot.redis.mapper"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
