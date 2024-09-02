package io.drivasaf.springboot.quickstart.entity;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:17
 * @description:
 **/
public class Meeting {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isOverlapping(Meeting other) {
        // 两个会议是否在同⼀天
        return this.date.equals(other.date) &&
                (this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime));
    }
}

