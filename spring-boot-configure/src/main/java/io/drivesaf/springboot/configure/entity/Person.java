package io.drivesaf.springboot.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 14:51
 * @description:
 **/
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String firstName;
    private String lastName;
    private String id;
    private Integer age;
    private Integer phone;
}
