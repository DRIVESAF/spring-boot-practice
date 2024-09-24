package io.drivesaf.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 13:56
 * @description:
 **/
@Data
@Component
public class Server {
    @Value("${server.host}")
    private String host;
    @Value("${server.port}")
    private Integer port;
    @Value("${server.context-path}")
    private String contextPath;
}
