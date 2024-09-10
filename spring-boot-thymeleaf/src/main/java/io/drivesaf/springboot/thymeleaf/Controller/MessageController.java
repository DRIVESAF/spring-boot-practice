package io.drivesaf.springboot.thymeleaf.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 14:35
 * @description:
 **/

@Controller
public class MessageController {
    @GetMapping("/msg")
    public String getMsg(Model model){
        model.addAttribute("message","Hello,Thymeleaf!");
        return "msg";
    }
}
