package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.common.ResponseResult;
import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.service.QuestionService;
import io.drivesaf.springboot.faq.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 15:06
 * @description:
 **/
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final JwtUtil jwtUtil;
    private final QuestionService questionService;

    public QuestionController(JwtUtil jwtUtil, QuestionService questionService) {
        this.jwtUtil = jwtUtil;
        this.questionService = questionService;
    }

    @PostMapping("/ask")
    public ResponseResult askQuestion(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> questionData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");

        // 获取问题内容
        String content = questionData.get("content");

        // 保存问题
        questionService.createQuestion(content, userId);

        return ResponseResult.builder()
                .code(200)
                .msg("提问发送成功")
                .build();
    }

    // 用户查询所有问题
    @GetMapping("/all")
    public ResponseResult getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions(); // 返回所有问题
        return ResponseResult.builder()
                .code(200)
                .msg("查询成功")
                .data(questions)
                .build();
    }

    // 查询特定问题的详细信息
    @GetMapping("/{questionId}")
    public ResponseResult getQuestionDetail(@PathVariable Integer questionId) {
        Question question = questionService.getQuestionDetail(questionId);
        return ResponseResult.builder()
                .code(200)
                .msg("查询成功")
                .data(question)
                .build();
    }

    // 模糊查询
    @GetMapping("/search")
    public ResponseResult searchQuestions(@RequestParam String content) {
        List<Question> questions = questionService.searchQuestionsByContent(content);
        return ResponseResult.builder()
                .code(200)
                .msg("查询成功")
                .data(questions)
                .build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseResult deleteQuestion(
            @RequestHeader(value = "Authorization", required = true) String token,
            @PathVariable Integer questionId) {

        // 验证 JWT token
        if (token == null || token.isEmpty() || !jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");

        // 删除问题
        boolean isDeleted = questionService.deleteQuestion(questionId, userId);
        if (isDeleted) {
            return ResponseResult.builder()
                    .code(200)
                    .msg("提问删除成功")
                    .build();
        } else {
            return ResponseResult.builder()
                    .code(403)
                    .msg("只能删除自己的提问")
                    .build();
        }
    }


    @PutMapping("/{questionId}")
    public ResponseResult updateQuestion(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer questionId,
            @RequestBody Map<String, String> questionData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return ResponseResult.builder()
                    .code(401)
                    .msg("用户未登录")
                    .build();
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");

        // 获取新内容
        String newContent = questionData.get("content");

        // 修改问题
        boolean isUpdated = questionService.updateQuestion(questionId, newContent, userId);
        if (isUpdated) {
            return ResponseResult.builder()
                    .code(200)
                    .msg("提问修改成功")
                    .build();
        } else {
            return ResponseResult.builder()
                    .code(403)
                    .msg("只能修改自己的提问")
                    .build();
        }
    }


}
