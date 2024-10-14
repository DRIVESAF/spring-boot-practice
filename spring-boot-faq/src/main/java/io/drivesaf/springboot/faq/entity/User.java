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
 * @createTime: 2024/10/13 14:34
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String userName;  // userName 改为 username 以保持一致
    private String password;
    private String email;
    private LocalDateTime createDate;  // 使用 LocalDateTime
    private List<Question> questions;  // 用户提出的多个问题
    private List<Answer> answers;  // 用户给出的多个回答
}
