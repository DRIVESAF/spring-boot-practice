package io.drivesaf.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.task.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 16:24
 * @description:
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
