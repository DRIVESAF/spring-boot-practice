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
    private LocalDateTime createDate;  // 使用 LocalDateTime 代替 LocalDate
    private User user;  // 提问者
}
