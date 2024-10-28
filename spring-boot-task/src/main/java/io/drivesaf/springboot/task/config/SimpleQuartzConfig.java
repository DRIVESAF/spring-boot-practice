package io.drivesaf.springboot.task.config;

import io.drivesaf.springboot.task.jobs.SimpleQuartzTak;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 16:03
 * @description:
 **/
// @Configuration
// public class SimpleQuartzConfig {
//     @Bean
//     public JobDetail jobDetail(){
//         return JobBuilder.newJob(SimpleQuartzTak.class)
//                 .withIdentity("simpleQuartzTask")
//                 .storeDurably()
//                 .build();
//     }
//
//     @Bean
//     public Trigger trigger(){
//         CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//         return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("simpleQuartzTask").withSchedule(scheduleBuilder).build();
//     }
// }
