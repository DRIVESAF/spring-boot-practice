package io.drivesaf.springboot.faq.service;

import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 15:05
 * @description:
 **/
@Service
public class QuestionService {

    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    // 创建问题并保存到数据库
    public void createQuestion(String content, Integer userId) {
        Question question = Question.builder()
                .content(content)
                .createdAt((int) (System.currentTimeMillis() / 1000)) // 生成当前时间戳（单位：秒）
                .user(User.builder().userId(userId).build())
                .build();
        questionMapper.insertQuestion(question);
    }

    public List<Question> getAllQuestions() {
        return questionMapper.selectAllQuestions(); // 查询所有问题
    }

    public Question getQuestionDetail(Integer questionId) {
        return questionMapper.selectQuestionDetail(questionId); // 查询特定问题的详细信息
    }

    public List<Question> searchQuestionsByContent(String content) {
        return questionMapper.selectQuestionsByContent(content);
    }

}