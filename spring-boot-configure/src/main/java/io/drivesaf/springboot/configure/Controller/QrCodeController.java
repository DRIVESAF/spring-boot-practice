package io.drivesaf.springboot.configure.Controller;

import io.drivesaf.springboot.configure.service.QrCodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 18:54
 * @description:
 **/
@RestController
@AllArgsConstructor
public class QrCodeController {
    private final QrCodeService qrCodeService;
    @GetMapping("/qrcode")
    public void qrcode() {
        qrCodeService.generateQrCode();
    }
}
