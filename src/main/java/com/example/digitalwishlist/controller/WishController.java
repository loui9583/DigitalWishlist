package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.Wish;
import com.example.digitalwishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishController {
    @Autowired
    WishService wishService;

    @PostMapping("/openwishlist")
    String openWishList(Model model, @RequestParam int wishlist_id) {

        List<Wish> wishes = wishService.getWishesFromWishList(wishlist_id);

        model.addAttribute("wishes", wishes);

        return "openwishlist";
    }


}
