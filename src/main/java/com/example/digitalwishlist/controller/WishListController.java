package com.example.digitalwishlist.controller;


import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.model.WishList;
import com.example.digitalwishlist.service.UserService;
import com.example.digitalwishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishListController {

    @Autowired
    WishListService wishListService;
    @Autowired
    UserService userService;

    @PostMapping("/createWishList")
    public String newWishList(Model model, @RequestParam int user_id, @RequestParam String wishlist_name) {
        WishList wishList = new WishList();
        wishList.setWishList_name(wishlist_name);
        wishList.setUser_id(user_id);
        wishListService.generateWishList(wishList);
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        model.addAttribute("wishLists", wishListService.getUserWishLists(user.getUser_id()));
        return "userinfo";
    }

    @PostMapping("/goBackToUser")
    public String goBackToUser(Model model, @RequestParam int wishListId) {
        User user = userService.getUser(wishListService.getWishList(wishListId).getUser_id());
        model.addAttribute("user", user);
        model.addAttribute("wishLists", wishListService.getUserWishLists(user.getUser_id()));
        return "userinfo";
    }






}
