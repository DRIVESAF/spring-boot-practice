package io.drivesaf.springboot.faq.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/13 14:38
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    private Integer questionId;  //
    private String content;
    private Integer createdAt; // 将类型改为 Integer 用于存储时间戳
    private User user;  // 提问者
    private List<Answer> answers; // 问题的所有回答
}
