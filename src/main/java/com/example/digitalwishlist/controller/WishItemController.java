package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.Item;
import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.service.ItemService;
import com.example.digitalwishlist.service.WishItemService;
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


    @PostMapping("/openwishlist")
    public String openWishlist(Model model, @RequestParam int wishlist_id){
        List<WishItem> wishItems = wishItemService.getWishesFromWishlist(wishlist_id);
        List<Item> itemList = itemService.getItems();
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


}
