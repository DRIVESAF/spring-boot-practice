package io.drivesaf.springboot.faq.controller;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/25 11:22
 * @description:
 **/
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
