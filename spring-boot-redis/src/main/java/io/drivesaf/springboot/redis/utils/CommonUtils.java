package io.drivesaf.springboot.redis.utils;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/21 14:55
 * @description:
 **/
public class CommonUtils {
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}

