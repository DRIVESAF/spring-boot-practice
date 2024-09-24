package io.drivesaf.springboot.zhihu.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 14:57
 * @description:
 **/
@SpringBootApplication
@MapperScan(basePackages = {"io.drivesaf.zhihu.api.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
