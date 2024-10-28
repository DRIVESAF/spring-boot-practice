package io.drivesaf.springboot.task.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 16:00
 * @description:
 **/
// @Slf4j
// public class SimpleQuartzTak extends QuartzJobBean {
//     @Override
//     protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//         log.info("SimpleQuartzTak,执行时间{}", LocalDateTime.now());
//     }
// }
