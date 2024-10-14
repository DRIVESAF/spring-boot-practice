package io.drivesaf.springboot.mp.service;

import io.drivesaf.springboot.mp.entity.Clazz;
import io.drivesaf.springboot.mp.entity.Teacher;
import io.drivesaf.springboot.mp.mapper.ClazzMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 15:47
 * @description:
 **/
@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;
    /**
     * 根据班级ID获取班级和对应⽼师
     */
    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}

