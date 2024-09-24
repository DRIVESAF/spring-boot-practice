package io.drivesaf.springboot.configure.mapper;

import io.drivesaf.springboot.configure.entity.Special;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 22:07
 * @description:
 **/
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;
    @Test
    void findAll() {
        List<Special> specials = specialMapper.findAll();
        specials.forEach(System.out::println);
    }
}
