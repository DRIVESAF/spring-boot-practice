package io.drivesaf.springboot.configure.entity;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 19:18
 * @description:
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    private String body;
}

