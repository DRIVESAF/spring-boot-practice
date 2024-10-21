package io.drivesaf.springboot.redis.config;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 14:56
 * @description:
 **/
public class RedisKeys {
    /**
     * 验证码Key
     */
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }
    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }
    /**
     * 获取⽤户 ID 密钥
     *
     * @param id id
     * @return {@link String}
     */
    public static String getUserIdKey(Long id) {
        return "sys:userId:" + id;
    }
}