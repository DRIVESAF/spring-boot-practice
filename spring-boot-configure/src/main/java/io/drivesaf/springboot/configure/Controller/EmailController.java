package io.drivesaf.springboot.configure.Controller;

import io.drivesaf.springboot.configure.entity.Mail;
import io.drivesaf.springboot.configure.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 19:19
 * @description:
 **/
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/mail") // 修改为POST方法
    public void sendEmail(@RequestBody Mail mail) {
        emailService.sendSimpleEmail(mail.getTo(), mail.getSubject(), mail.getBody());
    }
}
