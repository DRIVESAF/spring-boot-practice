package io.drivesaf.springboot.faq.service;

import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/14 13:14
 * @description:
 **/
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 注册用户
    public void registerUser(User user) {
        // 可以在此进行密码加密
        user.setCreatedAt((int) (System.currentTimeMillis() / 1000)); // 设置创建时间
        userMapper.insertUser(user); // 插入用户到数据库
    }

    // 根据用户名查询用户（从数据库 t_user 表中获取）
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
