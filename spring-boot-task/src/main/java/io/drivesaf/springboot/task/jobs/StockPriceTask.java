package io.drivesaf.springboot.task.jobs;

import io.drivesaf.springboot.task.entity.StockPrice;
import io.drivesaf.springboot.task.mapper.StockPriceMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
import java.text.DecimalFormat;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 14:58
 * @description: 定时任务，每隔十秒更新一次股票价格并持久化到数据库
 **/


// @Component
@AllArgsConstructor
public class StockPriceTask {
    private static final Logger log = LoggerFactory.getLogger(StockPriceTask.class);
    private final StockPriceMapper stockPriceMapper;
    private final Random random = new Random();

    @Scheduled(fixedRate = 10000)
    public void updateStockPrice() {
        double price = 100 + random.nextDouble() * 50;

        // 使用 DecimalFormat 格式化价格
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedPrice = df.format(price);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(Double.parseDouble(formattedPrice)); // 存储为double
        stockPrice.setName("小米");
        stockPrice.setUpdateTime(LocalDateTime.now());

        stockPriceMapper.insert(stockPrice);
        log.info("股票价格已更新：{}，时间：{}", formattedPrice, LocalDateTime.now());
    }
}
