package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.service.ItemService;
import com.example.digitalwishlist.service.WishItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishItemController {
    @Autowired
    WishItemService wishItemService;
    @Autowired
    ItemService itemService;

    @PostMapping("/openwishlist")
    String openWishList(Model model, @RequestParam int wishlist_id) {
        model.addAttribute("items", itemService.getItems());
        List<WishItem> wishItems = wishItemService.getWishesFromWishList(wishlist_id);
        model.addAttribute("wishListId", wishlist_id);
        model.addAttribute("wishItem", wishItems);
        return "openwishlist";
    }

/* @PostMapping("/addwishtowishlist")
    String addWish(Model model, @RequestParam int wishList_id, @RequestParam int wish_id) {
        WishItem wish = new WishItem();
        wish.setWishlist_id(wishList_id);
        wish.setWish_id(wish_id);
        wishService.addWishToWishList(wish);
        return "openwishlist";
    }*/

}
