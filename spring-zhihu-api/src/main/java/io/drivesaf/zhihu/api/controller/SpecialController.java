package io.drivesaf.zhihu.api.controller;

import io.drivesaf.zhihu.api.common.ResponseResult;
import io.drivesaf.zhihu.api.entity.Special;
import io.drivesaf.zhihu.api.service.SpecialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 16:21
 * @description:
 **/
@RestController
@RequestMapping("/api/v1/special")
public class SpecialController {
    @Resource
    private SpecialService specialService;

    @GetMapping("/all")
    public ResponseResult selectAll(){
        List<Special> all = specialService.selectAll();
        return ResponseResult.builder()
                .code(200)
                .msg("数据获取成功")
                .data(all)
                .build();
    }

    @GetMapping("/page")
    public ResponseResult getByPage(@RequestParam int limit, @RequestParam int offset){
        Map<String,Object> map = new HashMap<>();
        List<Special> specials = specialService.getByPage(limit,offset);
        map.put("specials",specials);
        map.put("total",specialService.selectAll().size());
        return ResponseResult.builder()
                .code(200)
                .msg("数据获取成功")
                .data(map)
                .build();
    }

}
