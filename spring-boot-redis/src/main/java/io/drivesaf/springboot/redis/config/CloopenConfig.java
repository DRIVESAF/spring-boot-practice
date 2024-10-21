package io.drivesaf.springboot.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 14:57
 * @description: CloopenConfig,统一读取短信发送的配置信息
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "drivesaf.sms.ccp")
public class CloopenConfig {
    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;
}
