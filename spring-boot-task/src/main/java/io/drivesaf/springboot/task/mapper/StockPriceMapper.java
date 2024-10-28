package io.drivesaf.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.drivesaf.springboot.task.entity.StockPrice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 14:56
 * @description:
 **/
@Mapper
public interface StockPriceMapper extends BaseMapper<StockPrice> {
}
