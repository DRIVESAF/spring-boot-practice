package io.drivesaf.springboot.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 14:15
 * @description:
 **/

@SpringBootApplication
@MapperScan(basePackages = {"io.drivesaf.springboot.mp.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

