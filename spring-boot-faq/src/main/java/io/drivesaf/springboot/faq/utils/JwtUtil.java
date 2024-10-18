package io.drivesaf.springboot.faq.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import io.drivesaf.springboot.faq.config.JwtConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;



/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 22:14
 * @description:
 **/
@Component
public class JwtUtil {
    @Resource
    private JwtConfig jwtConfig;

    // 生成 JWT Token
    public String generateToken(Map<String, Object> claims) {
        claims.put("exp", new Date(System.currentTimeMillis() + jwtConfig.getExpiration()));
        return JWTUtil.createToken(claims, jwtConfig.getSecret().getBytes());
    }

    // 验证 JWT Token
    public boolean validateToken(String token) {
        return JWTUtil.verify(token, jwtConfig.getSecret().getBytes());
    }

    // 获取 JWT 中的 Claims
    public Map<String, Object> getClaims(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        return jwt.getPayload().getClaimsJson();
    }
}