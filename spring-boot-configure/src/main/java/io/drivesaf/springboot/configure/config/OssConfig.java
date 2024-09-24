package io.drivesaf.springboot.configure.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties
        ;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 21:18
 * @description:
 **/
@Configuration
@PropertySource("classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "aliyun-oss")
@Data
public class OssConfig {
    private String endpoint;
    private String bucket;
    private String dir;
    private String host;
    private String ak;
    private String secret;
}