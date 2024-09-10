package io.drivesaf.springboot.quickstart.service;

import io.drivesaf.springboot.quickstart.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:49
 * @description:
 **/
@Service
public class UserService {
    private final List<User> users = List.of(
            new User(1L, "张三", 22),
            new User(2L, "张三丰", 17),
            new User(3L, "张三疯", 19),
            new User(4L, "张三⻛", 16),
            new User(5L, "张三峰", 25)
    );
    public List<String> getAdultUserNames() {
        return users.stream()
                // 过滤年龄⼤于18岁的⽤户
                .filter(user -> user.getAge() > 18)
                // 提取名字
                .map(User::getName)
                .collect(Collectors.toList());
    }
}