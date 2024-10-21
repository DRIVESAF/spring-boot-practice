package io.drivesaf.springboot.redis.controller;

import io.drivesaf.springboot.redis.cache.TokenStoreCache;
import io.drivesaf.springboot.redis.enums.ErrorCode;
import io.drivesaf.springboot.redis.exception.ServerException;
import io.drivesaf.springboot.redis.utils.JwtUtil;
import io.drivesaf.springboot.redis.vo.UserInfoVO;
import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import io.drivesaf.springboot.redis.result.Result;
import io.drivesaf.springboot.redis.service.UserService;
import io.drivesaf.springboot.redis.vo.UserLoginVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 16:38
 * @description:
 **/
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "⼿机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String
                                                    phone, @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }

    @GetMapping("info")
    @Operation(summary = "查询⽤户信息")
    public Result<UserInfoVO> userInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        // 校验token
        if (!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        // 验证⽤户登录状态是否正常
        UserLoginVO user = tokenStoreCache.getUser(accessToken);
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }
        // 验证⽤户是否可⽤
        boolean enabledFlag = userService.checkUserEnabled(user.getPkId());
        if (!enabledFlag) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        return Result.ok(userService.userInfo(user.getPkId()));
    }


}