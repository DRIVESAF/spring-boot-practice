package io.drivesaf.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.mp.entity.Clazz;
import io.drivesaf.springboot.mp.entity.Teacher;
import org.apache.ibatis.annotations.Select;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:42
 * @description:
 **/
public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);
}