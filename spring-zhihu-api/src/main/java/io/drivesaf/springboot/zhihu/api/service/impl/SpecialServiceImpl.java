package io.drivesaf.springboot.zhihu.api.service.impl;

import io.drivesaf.springboot.zhihu.api.entity.Special;
import io.drivesaf.springboot.zhihu.api.service.SpecialService;
import io.drivesaf.springboot.zhihu.api.mapper.SpecialMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 15:31
 * @description:
 **/
@Service
public class SpecialServiceImpl implements SpecialService {
    @Resource
    private SpecialMapper specialMapper;

    // 格式化日期的方法
    private void formatUpdatedTimestamp(List<Special> items) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        items.forEach(item -> {
            // 将 Unix 时间戳从秒转换为毫秒并格式化为日期字符串
            String formattedDate = df.format(new Date(Long.parseLong(item.getUpdated() + "000")));
            item.setUpdated(formattedDate);
        });
    }

    @Override
    public List<Special> selectAll() {
        List<Special> items = specialMapper.selectAll();
        // 调用时间戳格式化方法
        formatUpdatedTimestamp(items);
        System.out.println(items);
        return items;
    }

    @Override
    public List<Special> getByPage(int limit, int offset) {
        // 从数据库中获取分页的数据
        List<Special> items = specialMapper.selectByPage(limit, offset);
        // 调用时间戳格式化方法
        formatUpdatedTimestamp(items);
        return items;
    }
}
