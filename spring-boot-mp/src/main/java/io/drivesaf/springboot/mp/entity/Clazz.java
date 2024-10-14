package io.drivesaf.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:37
 * @description:
 **/
@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;

    // 声明数据表中不存在 teacher 列，一对一
    @TableField(exist = false)
    private Teacher teacher;
}
