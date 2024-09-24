package io.drivesaf.springboot.configure.entity;

import io.drivesaf.springboot.configure.loader.YamlPropertyLoader;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 14:56
 * @description:
 **/
@Data
@Component
@ConfigurationProperties(prefix = "family")
@Validated

@PropertySource(value = {"classpath:application.yml"}, factory = YamlPropertyLoader.class)
// @PropertySource(value = {"classpath:family.properties"})

public class Family {
    @Length(min = 5, max = 10, message = "家庭名称必须在5到10位之间！")
    private String familyName;  // 注意这里的命名
    private String father;
    private String mother;
    private String child;

    @Range(min = 3, message = "家庭年限必须大于3年！")
    private Integer age;
}

