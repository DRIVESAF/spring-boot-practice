package io.drivesaf.springboot.faq.service;

import io.drivesaf.springboot.faq.entity.Answer;
import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.AnswerMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 16:00
 * @description:
 **/
@Service
public class AnswerService {

    private final AnswerMapper answerMapper;

    public AnswerService(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public void createAnswer(String content, Integer questionId, Integer userId) {
        Answer answer = Answer.builder()
                .content(content)
                .createdAt((int) (Instant.now().getEpochSecond())) // 生成当前时间戳（单位：秒）
                .user(User.builder().userId(userId).build())      // 设置回答者
                .question(Question.builder().questionId(questionId).build()) // 设置问题
                .build();
        answerMapper.insertAnswer(answer); // 插入回答到数据库
    }
}
