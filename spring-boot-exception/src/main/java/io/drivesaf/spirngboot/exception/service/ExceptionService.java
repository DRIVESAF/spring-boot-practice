package io.drivesaf.spirngboot.exception.service;

import io.drivesaf.spirngboot.exception.exception.ServerException;
import org.springframework.stereotype.Service;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/15 13:43
 * @description:
 **/
@Service
public class ExceptionService {
    /**
     * 模拟未登录异常
     */
    public void unAuthorizedError() {
        throw new ServerException("没有登录");
    }
    /**
     *模拟系统异常
     */
    public void systemError() {
        throw new ServerException("系统异常");
    }
}

