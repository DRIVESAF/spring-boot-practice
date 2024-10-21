package io.drivesaf.springboot.faq.service;

import io.drivesaf.springboot.faq.entity.Question;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 15:05
 * @description:
 **/

public interface QuestionService {
    void createQuestion(String content, Integer userId);
    List<Question> getAllQuestions();
    Question getQuestionDetail(Integer questionId);
    List<Question> searchQuestionsByContent(String content);
    boolean deleteQuestion(Integer questionId, Integer userId);
    boolean updateQuestion(Integer questionId, String newContent, Integer userId);
}