package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.service.UserService;
import com.example.digitalwishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    WishListService wishListService;

    @GetMapping("/signUpPage")
    public String signUp() {
        return "createuserpage";
    }

    @PostMapping("/SignUp")
    public String newSignUp(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam String user_name, @RequestParam String user_password, Model model) {
        User user = userService.logIn(user_name, user_password);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("wishlists", wishListService.getUserWishlists(user.getUser_id()));
            return "userinfo";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }

    @PostMapping("/back")
    public String backToLogin(@RequestParam int user_id, Model model) {
        User user = userService.getUser(user_id);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("wishlists", wishListService.getUserWishlists(user.getUser_id()));
            return "userinfo";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }

}
