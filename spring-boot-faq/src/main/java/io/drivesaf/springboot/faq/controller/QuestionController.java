package io.drivesaf.springboot.faq.controller;

import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.entity.User;
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
    public Map<String, String> askQuestion(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> questionData) {

        // 验证 JWT token
        if (!jwtUtil.validateToken(token)) {
            return Map.of("error", "Invalid token");
        }

        // 从 token 中提取用户信息
        Integer userId = (Integer) jwtUtil.getClaims(token).get("userId");

        // 获取问题内容
        String content = questionData.get("content");

        // 保存问题
        questionService.createQuestion(content, userId);

        return Map.of("message", "Question created successfully");
    }

    // 用户查询所有问题
    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions(); // 返回所有问题
    }

    // 查询特定问题的详细信息
    @GetMapping("/{questionId}")
    public Question getQuestionDetail(@PathVariable Integer questionId) {
        return questionService.getQuestionDetail(questionId);
    }

    // 模糊查询
    @GetMapping("/search")
    public List<Question> searchQuestions(@RequestParam String content) {
        return questionService.searchQuestionsByContent(content);
    }


}