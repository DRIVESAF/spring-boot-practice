package io.drivesaf.springboot.faq.mapper;

import io.drivesaf.springboot.faq.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/16 16:01
 * @description:
 **/
@Mapper
public interface AnswerMapper {
    void insertAnswer(Answer answer); // 插入回答
}
