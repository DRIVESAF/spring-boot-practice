package io.drivesaf.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.config.Task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 14:16
 * @description:倒计时定时器
 **/
@Slf4j
public class CountdownTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countdown = 10;
            @Override
            public void run() {
                if (countdown > 0) {
                    log.info("倒计时：{} 秒",countdown);
                    countdown--;
                }else {
                    log.info("倒计时结束!");
                    // 释放倒计时
                    timer.cancel();
                }
            }
        };
        timer.schedule(task,0,1000);
    }
}
