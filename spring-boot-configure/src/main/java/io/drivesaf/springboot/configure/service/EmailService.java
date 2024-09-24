package io.drivesaf.springboot.configure.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 19:17
 * @description:
 **/

@Service
@Slf4j
public class EmailService {
    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件⼈邮箱
        message.setFrom(from);
        // 收件⼈邮箱
        message.setTo(to);
        // 邮件主题
        message.setSubject(subject);
        // 邮件内容
        message.setText(body);
        // 发送邮件
        mailSender.send(message);
        log.info("邮件已发送！");
    }
}