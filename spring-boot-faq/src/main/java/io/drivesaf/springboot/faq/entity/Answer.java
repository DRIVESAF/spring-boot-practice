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
 * @createTime: 2024/10/13 14:41
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    private Integer answerId;      // 回答ID
    private String content;        // 回答内容
    private Integer createdAt;     // 创建时间（时间戳）
    private User user;             // 回答者
    private Question question;      // 回答的问题
}