package io.drivesaf.springboot.task.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 14:11
 * @description:
 **/
public class ReminderTimer {
    private static final Logger log = LoggerFactory.getLogger(ReminderTimer.class);

    public static void main(String[] args) {
        // 定时器 timer
        Timer timer = new Timer();
        // 任务 task
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // 要做的事情
                log.info("请休息一下，喝口水吧");
            }
        };
        // 每隔五秒执行任务
        timer.schedule(task, 0, 5000);
    }
}
