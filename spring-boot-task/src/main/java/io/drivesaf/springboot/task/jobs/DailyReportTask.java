package io.drivesaf.springboot.task.jobs;

import io.drivesaf.springboot.task.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 15:42
 * @description:
 **/
// @Component
@AllArgsConstructor
@Slf4j
public class DailyReportTask {
    private final MailService mailService;

    @Scheduled(cron = "0 56 15 * * ?")
    public void sendReport() {
        String report = "这是每日报表内容";
        mailService.sendMail("axao@foxmail.com","每日数据报表",report);
        log.info("报表已生成，并发送邮件完成！{}", LocalDateTime.now());
    }
}
