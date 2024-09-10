package io.drivesaf.springboot.logging.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 16:20
 * @description:
 **/
@RestController
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    @GetMapping("/log")
    public String logDemo() {
        logger.trace("This is a TRACE log");
        logger.debug("This is a DEBUG log");
        logger.info("This is an INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is an ERROR log");
        return "Logs have been generated!";
    }
}

