package io.drivasaf.springboot.quickstart.controller;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:50
 * @description:
 **/
import io.drivasaf.springboot.quickstart.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/adults")
    public List<String> getAdultUserNames() {
        return userService.getAdultUserNames();
    }
}