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
    private Integer answerId;
    private String content;
    private LocalDateTime createDate;  // 使用 LocalDateTime 代替 LocalDate
    private User user;  // 回答者
    private Question question;  // 对应一个问题
}
