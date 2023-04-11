package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    TestRepo repo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", repo.findAll());
        return "index";

    }
}
