package io.drivesaf.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.drivesaf.springboot.redis.entity.User;
import io.drivesaf.springboot.redis.vo.UserInfoVO;
import io.drivesaf.springboot.redis.vo.UserLoginVO;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 16:29
 * @description:
 **/
public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone, String code);

    /**
     * 检查⽤户是否启⽤
     *
     * @param userId ⽤户 ID
     * @return boolean
     */
    boolean checkUserEnabled(Long userId);
    /**
     * 获取⽤户信息
     *
     * @param userId ⽤户 ID
     * @return {@link UserInfoVO}
     */
    UserInfoVO userInfo(Long userId);

}

