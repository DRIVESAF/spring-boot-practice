package io.drivesaf.springboot.configure.mapper;

import io.drivesaf.springboot.configure.entity.Special;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 22:07
 * @description:
 **/
@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM list ORDER BY updated DESC ")
    List<Special> findAll();
}

