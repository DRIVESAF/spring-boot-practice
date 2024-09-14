package io.drivesaf.zhihu.api.service;

import io.drivesaf.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 15:31
 * @description:
 **/
public interface SpecialService {

    /**
     * 获取所有 Special 实体的列表
     *
     * @return List<Special> 包含所有 Special 实体的列表
     */
    List<Special> selectAll();
    List<Special> getByPage(int limit,int offset);
}
