package io.drivesaf.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 13:58
 * @description:
 **/
@SpringBootTest
class ServerTest {
    @Resource
    private Server server;

    @Test
    void testServer() {
        System.out.println(server);
    }
}