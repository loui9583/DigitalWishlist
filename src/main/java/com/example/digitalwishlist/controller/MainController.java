package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/signUpForm")
    public String signUp() {
        return "/createuser";
    }

    @PostMapping("/newSignUp")
    public String newSignUp(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "loginform";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam("user_name") String user_name, @RequestParam("user_password") String user_password, Model model) {
        User user = userService.logIn(user_name, user_password);
        if (user != null) {
            model.addAttribute("user", user);
            return "userinfo";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginform";
        }
    }
}
