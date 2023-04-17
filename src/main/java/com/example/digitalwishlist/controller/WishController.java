package com.example.digitalwishlist.controller;

import com.example.digitalwishlist.model.Item;
import com.example.digitalwishlist.model.Wish;
import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.repository.WishItemRepo;
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

    @PostMapping("/addwish")
        public String addWish(Model model, @RequestParam int wishlist_id, @RequestParam int item_id){
        wishService.addWish(wishlist_id, item_id);
        model.addAttribute("wishlist_id", wishlist_id);
        List<WishItem> wishItems = wishItemService.getWishesFromWishlist(wishlist_id);
        List<Item> itemList = itemService.getItems();
        model.addAttribute("wishItems", wishItems);
        model.addAttribute("items", itemList);
        return "openwishlist";
    }

    @PostMapping("/reservewish")
    public String isReserved(Model model, @RequestParam int wish_id, @RequestParam boolean is_reserved, @RequestParam int wishlist_id) {
        wishService.isReserved(wish_id, is_reserved);
        model.addAttribute("wishlist_id", wishlist_id);
        String url="redirect:http://20.85.239.54:8080/wishlist/";
        url+=wishlist_id;
        return url;
    }

}
