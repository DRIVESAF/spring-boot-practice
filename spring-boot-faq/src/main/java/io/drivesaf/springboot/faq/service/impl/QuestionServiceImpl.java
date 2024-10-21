package io.drivesaf.springboot.faq.service.impl;

import io.drivesaf.springboot.faq.entity.Question;
import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.QuestionMapper;
import io.drivesaf.springboot.faq.service.QuestionService;
import io.drivesaf.springboot.faq.service.AnswerService; // 导入 AnswerService
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final AnswerService answerService; // 添加 AnswerService

    public QuestionServiceImpl(QuestionMapper questionMapper, AnswerService answerService) {
        this.questionMapper = questionMapper;
        this.answerService = answerService; // 注入 AnswerService
    }

    @Override
    public void createQuestion(String content, Integer userId) {
        Question question = Question.builder()
                .content(content)
                .createdAt((int) (System.currentTimeMillis() / 1000))
                .user(User.builder().userId(userId).build())
                .build();
        questionMapper.insertQuestion(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionMapper.selectAllQuestions();
    }

    @Override
    public Question getQuestionDetail(Integer questionId) {
        return questionMapper.selectQuestionDetail(questionId);
    }

    @Override
    public List<Question> searchQuestionsByContent(String content) {
        return questionMapper.selectQuestionsByContent(content);
    }

    @Override
    public boolean deleteQuestion(Integer questionId, Integer userId) {
        Question question = questionMapper.selectQuestionDetail(questionId);
        if (question != null && question.getUser().getUserId().equals(userId)) {
            answerService.deleteAnswersByQuestionId(questionId); // 删除相关回答
            questionMapper.deleteQuestion(questionId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateQuestion(Integer questionId, String newContent, Integer userId) {
        Question question = questionMapper.selectQuestionDetail(questionId);
        if (question != null && question.getUser().getUserId().equals(userId)) {
            questionMapper.updateQuestion(questionId, newContent);
            return true;
        }
        return false;
    }

}
