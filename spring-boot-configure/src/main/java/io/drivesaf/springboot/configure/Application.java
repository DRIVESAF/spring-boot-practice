package io.drivesaf.springboot.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 13:54
 * @description:
 **/
@SpringBootApplication
// 加载外部xml配置
@ImportResource(locations = {"classpath:beans.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}