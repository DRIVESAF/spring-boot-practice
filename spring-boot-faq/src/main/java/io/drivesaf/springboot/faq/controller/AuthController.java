package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.service.UserService;
import io.drivesaf.springboot.faq.utils.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 13:13
 * @description:
 **/
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthController(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    /**
     * 用户登录，验证用户名和密码，并生成JWT token
     * @param loginData 用户登录信息（包含username和password）
     * @return 返回生成的JWT token
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String userName = loginData.get("userName");
        String password = loginData.get("password");

        User user = userService.findByUserName(userName);

        Map<String, Object> response = new HashMap<>();
        if (user != null && user.getPassword().equals(password)) {
            // 用户名密码验证成功，生成 JWT token
            Map<String, Object> claims = new HashMap<>();
            claims.put("userName", user.getUserName());
            claims.put("userId", user.getUserId());
            String token = jwtUtil.generateToken(claims);
            response.put("token", token);
        } else {
            response.put("error", "Invalid username or password");
        }

        return response;
    }

    /**
     * 用户注册
     * @param user 注册信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        userService.registerUser(user); // 注册用户
        return Map.of("message", "User registered successfully");
    }
}
