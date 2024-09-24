package io.drivesaf.springboot.configure.utils;
import cn.hutool.jwt.JWTUtil;
import io.drivesaf.springboot.configure.config.JwtConfig;
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

    public String generateToken (Map<String,Object>claims){
        claims.put("exp",new Date(System.currentTimeMillis()+jwtConfig.getExpiration()));
        return JWTUtil.createToken(claims, jwtConfig.getSecret().getBytes());
    }

    public boolean validateToken (String token){
        return JWTUtil.verify(token, jwtConfig.getSecret().getBytes());
    }



}