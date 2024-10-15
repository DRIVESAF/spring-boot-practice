package io.drivesaf.spirngboot.exception.controller;

import io.drivesaf.spirngboot.exception.entity.User;
import io.drivesaf.spirngboot.exception.result.Result;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/15 13:52
 * @description:
 **/
@RestController
public class UserController {
    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult
            bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}
