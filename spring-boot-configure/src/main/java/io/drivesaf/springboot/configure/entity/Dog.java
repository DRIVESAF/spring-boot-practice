package io.drivesaf.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 17:48
 * @description:
 **/
@Data
@Component
public class Dog {
    @Value("${student.dog.name}")
    private String name;
    @Value("${student.dog.age}")
    private Integer age;
}
