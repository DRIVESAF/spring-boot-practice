package io.drivesaf.springboot.configure.service;

import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 18:52
 * @description:
 **/

@Service
@Slf4j
public class QrCodeService {
    @Value("${custom.qrcode.content}")
    private String qrContent;
    public void generateQrCode() {
        QrCodeUtil.generate(qrContent, 300, 300, new File("qrcode.png"));
        log.info("⼆维码⽣成成功！");
    }
}
