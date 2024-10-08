package io.drivesaf.zhihu.api.mapper;

import io.drivesaf.springboot.zhihu.api.entity.Special;
import io.drivesaf.springboot.zhihu.api.mapper.SpecialMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 15:22
 * @description:
 **/
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    @Test
    void selectAll() {
        List<Special> specials = specialMapper.selectAll();
        specials.forEach(System.out::println);
    }

    @Test
    void selectByPage() {
        List<Special> specials = specialMapper.selectByPage(2,0);
        specials.forEach(System.out::println);
    }

}