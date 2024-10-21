package io.drivesaf.springboot.faq.service.impl;

import io.drivesaf.springboot.faq.entity.Answer;
import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.AnswerMapper;
import io.drivesaf.springboot.faq.service.AnswerService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public void createAnswer(String content, Integer questionId, Integer userId) {
        Answer answer = Answer.builder()
                .content(content)
                .createdAt((int) (Instant.now().getEpochSecond())) // 生成当前时间戳（单位：秒）
                .user(User.builder().userId(userId).build())      // 设置回答者
                .question(Question.builder().questionId(questionId).build()) // 设置问题
                .build();
        answerMapper.insertAnswer(answer); // 插入回答到数据库
    }

    @Override
    public Answer findById(Integer answerId) {
        return answerMapper.findById(answerId);
    }

    @Override
    public void deleteAnswer(Integer answerId) {
        answerMapper.deleteAnswer(answerId);
    }

    @Override
    public boolean updateAnswer(Integer answerId, String newContent, Integer userId) {
        Answer answer = answerMapper.findById(answerId);
        if (answer != null && answer.getUser() != null && answer.getUser().getUserId().equals(userId)) {
            answerMapper.updateAnswer(answerId, newContent);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAnswersByQuestionId(Integer questionId) {
        answerMapper.deleteAnswersByQuestionId(questionId);
    }
}
