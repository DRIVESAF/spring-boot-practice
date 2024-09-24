package io.drivesaf.springboot.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 17:49
 * @description:
 **/
@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;
}