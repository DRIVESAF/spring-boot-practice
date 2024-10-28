package io.drivesaf.springboot.task.jobs;

import com.alibaba.excel.EasyExcel;
import io.drivesaf.springboot.task.entity.Student;
import io.drivesaf.springboot.task.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.UUID;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 16:25
 * @description:
 **/
@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    protected final StudentMapper studentMapper;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行任务！");
        List<Student> students = studentMapper.selectList(null);
        String fileName = "D:\\Users\\DRIVESAFE\\Desktop\\excel\\" + UUID.randomUUID() + ".xlsx";
        EasyExcel.write(fileName, Student.class)
                .sheet("学生数据")
                .doWrite(()->students);
    }
}
