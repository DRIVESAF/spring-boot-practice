package io.drivasaf.springboot.quickstart.service;

import io.drivasaf.springboot.quickstart.entity.Meeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:29
 * @description:
 **/
@Service
public class MeetingService {
    private final List<Meeting> meetings = new ArrayList<>();
    public boolean isRoomAvailable(Meeting newMeeting) {
        // 使⽤ Java Stream API 来检查会议列表中是否有与新会议重叠的会议
        return meetings.stream()
                // 如果存在任何与新会议时间重叠的现有会议，返回 false
                .noneMatch(existingMeeting -> existingMeeting.isOverlapping(newMeeting));
    }
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }
}