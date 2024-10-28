package io.drivesaf.springboot.task.config;

import io.drivesaf.springboot.task.jobs.ExportJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 16:30
 * @description:
 **/
@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("exportTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("exportTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
