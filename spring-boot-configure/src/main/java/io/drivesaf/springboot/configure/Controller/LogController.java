package io.drivesaf.springboot.configure.Controller;

import io.drivesaf.springboot.configure.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 19:07
 * @description:
 **/
@RestController
@AllArgsConstructor
public class LogController {
    private final LogService logService;
    @GetMapping("/log")
    public void logMsg() {
        logService.logMessage();
    }
}

