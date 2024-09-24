package io.drivesaf.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/24 9:06
 * @description:
 **/
@Data
@Configuration
@PropertySource(name = "employeeProperties", value = "classpath:employee.properties", encoding = "utf-8")
        public class Employee {
        /**
         * 使⽤ SpEL 读取 employee.properties 配置⽂件
         */
        @Value("#{'${employee.names}'.split(',')}")
        private List<String> employeeNames;
        }