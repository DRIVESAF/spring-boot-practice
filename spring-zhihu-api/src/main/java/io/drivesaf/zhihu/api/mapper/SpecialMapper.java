package io.drivesaf.zhihu.api.mapper;

import io.drivesaf.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 15:14
 * @description:
 **/

public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit,int offset);
}
