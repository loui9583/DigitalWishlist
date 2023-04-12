package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.repository.TestRepo;
import com.example.digitalwishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;



    @GetMapping("/signUp")
    public String signUp(){
        return "/createuser";
    }

    @PostMapping("/newSignUp")
    public String newSignUp(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){return "/login";}
    @PostMapping("/userLogin")
    public String newLogin(@ModelAttribute User user, Model model){
        User loggedInUser = userService.logIn(user.getUser_name(), user.getUser_password());
        if(loggedInUser != null){
            model.addAttribute("user", loggedInUser);
            return "mainPage";
        } else {
            return "index";
        }
    }
}
