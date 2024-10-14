package io.drivesaf.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 13:35
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    // 在一方中声明另一方
    private Teacher teacher;
    // 在一方中声明多方的集合
    private List<Student> students;
}
