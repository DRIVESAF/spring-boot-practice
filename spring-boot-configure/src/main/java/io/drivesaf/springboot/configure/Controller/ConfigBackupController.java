package io.drivesaf.springboot.configure.Controller;
import io.drivesaf.springboot.configure.service.ConfigBackupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 19:13
 * @description:
 **/
@RestController
@AllArgsConstructor
public class ConfigBackupController {
    private final ConfigBackupService configBackupService;
    @GetMapping("/backup")
    public void backupConfig() {
        configBackupService.backupConfigFile();
    }
}

