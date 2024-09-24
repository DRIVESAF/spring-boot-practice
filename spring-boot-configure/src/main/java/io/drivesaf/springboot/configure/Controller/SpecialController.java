package io.drivesaf.springboot.configure.Controller;

import io.drivesaf.springboot.configure.entity.Special;
import io.drivesaf.springboot.configure.mapper.SpecialMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 22:09
 * @description:
 **/
@RestController
public class SpecialController {
    @Resource
    private SpecialMapper specialMapper;
    @GetMapping("/specials")
    public List<Special> getSpecials() {
        return specialMapper.findAll();
    }
}

