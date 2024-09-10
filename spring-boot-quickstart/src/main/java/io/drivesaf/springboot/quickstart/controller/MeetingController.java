package io.drivesaf.springboot.quickstart.controller;

import io.drivesaf.springboot.quickstart.entity.Meeting;
import io.drivesaf.springboot.quickstart.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:46
 * @description:
 **/
@RestController
@RequestMapping("/meetings")
public class MeetingController {
    private final MeetingService meetingService;
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkAvailability(@RequestBody Meeting meeting) {
        // 调⽤服务⽅法检查会议室是否在该时间段内可⽤
        if (meetingService.isRoomAvailable(meeting)) {
            // 如果会议室可⽤，则添加会议并返回成功消息
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可⽤，会议已预订！");
        } else {
            // 如果会议室不可⽤，返回冲突状态和不可⽤的提示信息
            return ResponseEntity.status(409).body("会议室不可⽤！");
        }
    }
}
