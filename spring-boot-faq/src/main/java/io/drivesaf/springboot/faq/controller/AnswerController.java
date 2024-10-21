package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.common.ResponseResult;
import io.drivesaf.springboot.faq.entity.Answer;
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
    public ResponseResult createAnswer(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> answerData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");
        Integer questionId = Integer.parseInt(answerData.get("questionId"));
        String content = answerData.get("content");

        // 创建回答
        answerService.createAnswer(content, questionId, userId);

        return ResponseResult.builder()
                .code(200)
                .msg("回答成功")
                .build();
    }

    /**
     * 删除回答
     * @param token 用户的JWT Token
     * @param answerId 要删除的回答ID
     * @return 返回删除结果
     */
    // 删除回答
    @DeleteMapping("/{answerId}")
    public ResponseResult deleteAnswer(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer answerId) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");
        Answer answer = answerService.findById(answerId);
        System.out.println("Current User ID: " + userId); // 打印当前用户 ID
        System.out.println("Answer User ID: " + (answer != null ? answer.getUser().getUserId() : "null")); // 打印回答者 ID

        if (answer == null || answer.getUser() == null) {
            return ResponseResult.builder()
                    .code(403)
                    .msg("回答不存在或用户信息缺失")
                    .build();
        }

        if (!answer.getUser().getUserId().equals(userId)) {
            return ResponseResult.builder()
                    .code(403)
                    .msg("无权删除此回答")
                    .build();
        }

        answerService.deleteAnswer(answerId);
        return ResponseResult.builder()
                .code(200)
                .msg("回答删除成功")
                .build();
    }

    @PutMapping("/{answerId}")
    public ResponseResult updateAnswer(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer answerId,
            @RequestBody Map<String, String> answerData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");
        String newContent = answerData.get("content");

        // 更新回答
        boolean isUpdated = answerService.updateAnswer(answerId, newContent, userId);
        if (isUpdated) {
            return ResponseResult.builder()
                    .code(200)
                    .msg("回答修改成功")
                    .build();
        } else {
            return ResponseResult.builder()
                    .code(403)
                    .msg("只能修改自己的回答")
                    .build();
        }
    }



}
