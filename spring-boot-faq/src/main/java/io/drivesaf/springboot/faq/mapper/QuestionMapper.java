package io.drivesaf.springboot.faq.mapper;

import io.drivesaf.springboot.faq.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 15:04
 * @description:
 **/
@Mapper
public interface QuestionMapper {
    void insertQuestion(Question question); // 插入问题

    List<Question> selectAllQuestions(); // 查询所有问题

    Question selectQuestionDetail(Integer questionId); // 查询特定问题详细信息

    // 模糊查询问题内容
    List<Question> selectQuestionsByContent(String content); // 添加模糊查询方法
}
