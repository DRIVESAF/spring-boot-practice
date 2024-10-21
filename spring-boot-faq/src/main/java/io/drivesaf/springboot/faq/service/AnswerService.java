package io.drivesaf.springboot.faq.service;

import io.drivesaf.springboot.faq.entity.Answer;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 16:00
 * @description:
 **/
public interface AnswerService {
    void createAnswer(String content, Integer questionId, Integer userId);
    Answer findById(Integer answerId);
    void deleteAnswer(Integer answerId);
    boolean updateAnswer(Integer answerId, String newContent, Integer userId);
    void deleteAnswersByQuestionId(Integer questionId);
}
