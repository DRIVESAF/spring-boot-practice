package io.drivesaf.springboot.configure.Controller;

import io.drivesaf.springboot.configure.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 15:21
 * @description:
 **/
@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public String createUser(@Valid @RequestBody User user) {
        return "用户有效";
    }
}
