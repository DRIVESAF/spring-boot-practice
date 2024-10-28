package io.drivesaf.springboot.task.service;

import io.drivesaf.springboot.task.entity.EmailLog;
import io.drivesaf.springboot.task.mapper.EmailLogMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/28 15:36
 * @description:
 **/
@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final EmailLogMapper emailLogMapper;

    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("axao@foxmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);

        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(to);
        emailLog.setSubject(subject);
        emailLog.setContent(content);
        emailLog.setSentAt(LocalDateTime.now());
        emailLogMapper.insert(emailLog);
    }
}
