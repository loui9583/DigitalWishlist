package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.Item;
import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishItemController {

    @Autowired
    WishItemService wishItemService;
    @Autowired
    ItemService itemService;
    @Autowired
    WishService wishService;

    @Autowired
    WishListService wishListService;
    @Autowired
    UserService userService;

    @PostMapping("/openwishlist")
    public String openWishlist(Model model, @RequestParam int wishlist_id, @RequestParam int user_id){
        List<WishItem> wishItems = wishItemService.getWishesFromWishlist(wishlist_id);
        List<Item> itemList = itemService.getItems();
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        model.addAttribute("wishlist_id", wishlist_id);
        model.addAttribute("wishItems", wishItems);
        model.addAttribute("items", itemList);
        return "openwishlist";
    }

    @GetMapping("/wishlist/{wishlist_id}")
    String openWishListShare(Model model, @PathVariable int wishlist_id) {
        model.addAttribute("items", itemService.getItems());
        List<WishItem> wishItems = wishItemService.getWishesFromWishlist(wishlist_id);
        model.addAttribute("wishListId", wishlist_id);
        model.addAttribute("wishItems", wishItems);
        return "sharewishlist";
    }

    @PostMapping("/addwishitempage")
    public String addWishItemPage(Model model, @RequestParam int wishlist_id){
        model.addAttribute("wishlist_id", wishlist_id);
        return "createwishitempage";
    }

    @PostMapping ("/addwishitem")
    public String addWishItem(Model model, @RequestParam int wishlist_id, @RequestParam String item_name, @RequestParam String website, @RequestParam int price){
        itemService.addItem(item_name, price, website);
        int user_id = wishListService.getWishList(wishlist_id).getUser_id();

        User user = userService.getUser(user_id);

        int item_id = itemService.getNewestItemId();
        wishService.addWish(wishlist_id, item_id);
        model.addAttribute("user", user);
        model.addAttribute("wishlist_id", wishlist_id);
        model.addAttribute("wishItems", wishItemService.getWishesFromWishlist(wishlist_id));
        model.addAttribute("items", itemService.getItems());

        return "openwishlist";
    }

}
