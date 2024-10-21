package io.drivesaf.springboot.redis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.redis.entity.User;


/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 16:26
 * @description:
 **/
public interface UserMapper extends BaseMapper<User> {

    default User getByPhone(String phone){
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
    }
}

