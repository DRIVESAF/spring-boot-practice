package io.drivasaf.springboot.quickstart.service;

import io.drivasaf.springboot.quickstart.enums.RequestType;
import org.springframework.stereotype.Service;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 19:49
 * @description:
 **/
@Service
public class CustomerServcice {
    public String handleRequest(RequestType requestType) {
        return switch (requestType) {
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };
    }
    private String handleQuery() {
        return "Handling user query...";
    }
    private String handleComplaint() {
        return "Handling user complaint...";
    }
    private String handleSuggestion() {
        return "Handling user suggestion...";
    }
}
