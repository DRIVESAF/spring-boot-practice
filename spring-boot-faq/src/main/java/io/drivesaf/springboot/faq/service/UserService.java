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
public interface UserService {
    void registerUser(User user);
    User findByUserName(String userName);
}
