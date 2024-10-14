package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Teacher;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 13:39
 * @description:
 **/
public interface TeacherMapper {
    Teacher findTeacherById(int teacherId);
}
