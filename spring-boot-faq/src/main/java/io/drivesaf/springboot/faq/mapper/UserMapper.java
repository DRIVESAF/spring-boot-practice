package io.drivesaf.springboot.faq.mapper;

import io.drivesaf.springboot.faq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 13:26
 * @description:
 **/
@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}
