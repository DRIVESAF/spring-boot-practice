package io.drivesaf.spirngboot.exception.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.drivesaf.spirngboot.exception.service.ExceptionService;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/15 13:48
 * @description:
 **/
@RestController
public class ExceptionController {
    @Resource
    private ExceptionService exceptionService;
    @GetMapping("/articles/{id}")
    public void getArticle(@PathVariable("id") Integer id) {
        if (id == 1) {
            exceptionService.unAuthorizedError();
        } else {
            exceptionService.systemError();
        }
    }
}
