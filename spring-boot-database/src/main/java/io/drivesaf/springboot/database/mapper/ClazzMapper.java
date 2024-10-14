package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Clazz;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 13:49
 * @description:
 **/
public interface ClazzMapper {
    Clazz getClazzById(int clazzId);
    Clazz getClazz(int clazzId);
}
