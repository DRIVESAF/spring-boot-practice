package io.drivesaf.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.task.entity.EmailLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 15:36
 * @description:
 **/
@Mapper
public interface EmailLogMapper extends BaseMapper<EmailLog> {
}
