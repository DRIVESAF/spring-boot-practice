package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Course;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 15:32
 * @description:
 **/
public interface CourseMapper {
    /**
     * 查询所有课程（关联查询出每⻔课程的选课学⽣）
     * @return List<Course>
     */
    List<Course> selectAll();
}