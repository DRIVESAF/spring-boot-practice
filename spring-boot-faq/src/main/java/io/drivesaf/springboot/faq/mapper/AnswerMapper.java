package io.drivesaf.springboot.faq.mapper;

import io.drivesaf.springboot.faq.entity.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnswerMapper {
    void insertAnswer(Answer answer); // 插入回答
    void deleteAnswer(Integer answerId); // 删除回答
    Answer findById(Integer answerId); // 根据 ID 查找回答
    void updateAnswer(@Param("answerId") Integer answerId, @Param("content") String content);
    void deleteAnswersByQuestionId(Integer questionId);
}
