package io.drivesaf.springboot.redis.service;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 14:59
 * @description:
 **/
public interface SmsService {
    void sendSms(String phone);
}
