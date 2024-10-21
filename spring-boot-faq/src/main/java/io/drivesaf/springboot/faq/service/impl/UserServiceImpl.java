package io.drivesaf.springboot.faq.service.impl;

import io.drivesaf.springboot.faq.entity.User;
import io.drivesaf.springboot.faq.mapper.UserMapper;
import io.drivesaf.springboot.faq.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/20 16:34
 * @description:
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(User user) {
        // 这里可以进行密码加密等处理
        user.setCreatedAt((int) (Instant.now().getEpochSecond())); // 设置创建时间
        userMapper.insertUser(user); // 插入用户到数据库
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
