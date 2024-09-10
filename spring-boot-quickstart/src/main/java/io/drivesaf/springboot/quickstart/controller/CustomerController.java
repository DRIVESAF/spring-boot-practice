package io.drivesaf.springboot.quickstart.controller;

import io.drivesaf.springboot.quickstart.enums.RequestType;
import io.drivesaf.springboot.quickstart.service.CustomerServcice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 19:50
 * @description:
 **/
@RestController
@RequestMapping("/requests")
public class CustomerController {
    private final CustomerServcice customerService;
    public CustomerController(CustomerServcice customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{type}")
    public String handleRequest(@PathVariable RequestType type) {
        return customerService.handleRequest(type);
    }
}
