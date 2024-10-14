package io.drivesaf.springboot.database.mapper;

import io.drivesaf.springboot.database.entity.Special;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 16:43
 * @description:
 **/
public interface SpecialMapper {
    List<Special> findAll();
}
