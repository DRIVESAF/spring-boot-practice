package io.drivesaf.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:39
 * @description:
 **/
@Data
public class Student {
    private Long id;
    private String name;
    private Long clazzId;

    @TableField(exist = false)
    private List<Course> courses;
}
