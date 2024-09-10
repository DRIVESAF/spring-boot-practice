package io.drivesaf.springboot.thymeleaf.Controller;

import io.drivesaf.springboot.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 18:41
 * @description: User management controller
 **/
@Controller
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/userList")
    public String userList(Model model) {
        model.addAttribute("users", users);
        return "userList";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        Long id = (long) (users.size() + 1);
        User user = new User(id, email, name);
        users.add(user);
        return "redirect:/userList";
    }
}
