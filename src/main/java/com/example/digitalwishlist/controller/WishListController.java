package com.example.digitalwishlist.controller;


import com.example.digitalwishlist.model.WishList;
import com.example.digitalwishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishListController {

    @Autowired
    WishListService wishListService;

    @PostMapping("/createWishList")
    public String newWishList(@RequestParam int user_id, @RequestParam String wishlist_name) {
        WishList wishList = new WishList();
        wishList.setWishList_name(wishlist_name);
        wishList.setUser_id(user_id);
        wishListService.generateWishList(wishList);
        return "redirect:/";
    }

}
