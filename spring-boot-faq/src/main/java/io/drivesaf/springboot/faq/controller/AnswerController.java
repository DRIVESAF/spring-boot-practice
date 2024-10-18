package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.service.AnswerService;
import io.drivesaf.springboot.faq.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 16:02
 * @description:
 **/
@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final JwtUtil jwtUtil;
    private final AnswerService answerService;

    public AnswerController(JwtUtil jwtUtil, AnswerService answerService) {
        this.jwtUtil = jwtUtil;
        this.answerService = answerService;
    }

    /**
     * 用户回答问题
     * @param token 用户的JWT Token
     * @param answerData 回答内容
     * @return 返回回答结果
     */
    @PostMapping("/create")
    public Map<String, String> createAnswer(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> answerData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return Map.of("error", "Invalid token");
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");
        Integer questionId = Integer.parseInt(answerData.get("questionId"));
        String content = answerData.get("content");

        // 创建回答
        answerService.createAnswer(content, questionId, userId);

        return Map.of("message", "Answer created successfully");
    }
}