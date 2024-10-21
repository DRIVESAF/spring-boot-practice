package io.drivesaf.springboot.redis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 16:06
 * @description:
 **/
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("drivesaf 的 API")
                        .contact(new Contact().name("mqxu").email("axao@foxmail.com"))
                .version("1.0")
                .description("drivesaf 的 API 接⼝⽂档")
                .license(new License().name("Apache 2.0").url("http://doc.xiaominfo.com")));
    }
}
