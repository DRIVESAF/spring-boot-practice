package io.drivesaf.springboot.task.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 15:34
 * @description:
 **/
@Data
@TableName("email_log")
public class EmailLog {
    private Long id;
    private String recipient;
    private String content;
    private String subject;
    private LocalDateTime sentAt;

}
