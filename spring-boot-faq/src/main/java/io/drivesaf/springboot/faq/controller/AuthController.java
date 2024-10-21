package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.common.ResponseResult;
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.service.UserService;
import io.drivesaf.springboot.faq.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult login(@RequestBody Map<String, String> loginData) {
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
            return ResponseResult.builder()
                    .code(200)
                    .msg("登录成功")
                    .data(response)
                    .build();
        } else {
            return ResponseResult.builder()
                    .code(401)
                    .msg("无效用户名或密码")
                    .build();
        }
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        // 检查用户是否已存在
        User existingUser = userService.findByUserName(user.getUserName());
        if (existingUser != null) {
            return ResponseResult.builder()
                    .code(400)
                    .msg("用户已存在")
                    .build();
        }

        userService.registerUser(user); // 注册用户
        return ResponseResult.builder()
                .code(200)
                .msg("用户注册成功")
                .build();
    }
}
