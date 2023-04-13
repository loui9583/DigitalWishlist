package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.service.ItemService;
import com.example.digitalwishlist.service.WishItemService;
import com.example.digitalwishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishController {

    @Autowired
    WishService wishService;
    @Autowired
    ItemService itemService;
    @Autowired
    WishItemService wishItemService;

    @PostMapping("/addwishtowishlist")
    String addWishToWishList(Model model,@RequestParam int wishlist_id, @RequestParam int item_id) {
        model.addAttribute("items", itemService.getItems());
        wishService.addWishToWishList(wishlist_id, item_id);

        model.addAttribute("items", itemService.getItems());
        List<WishItem> wishItems = wishItemService.getWishesFromWishList(wishlist_id);
        model.addAttribute("wishListId", wishlist_id);
        model.addAttribute("wishItem", wishItems);
        return "openwishlist";
    }

    @PostMapping ("/addNewItem")
    String addNewItem(Model model,@RequestParam String item_name,  @RequestParam int item_price, @RequestParam int wishlist_id) {

        itemService.addItem(item_name, item_price);
        wishService.addWishToWishList(wishlist_id, itemService.getNewestItemId());

        model.addAttribute("items", itemService.getItems());
        List<WishItem> wishItems = wishItemService.getWishesFromWishList(wishlist_id);
        model.addAttribute("wishListId", wishlist_id);
        model.addAttribute("wishItem", wishItems);
        return "openwishlist";
    }



}
