package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.repository.WishItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishItemService {
    @Autowired
    WishItemRepo wishRepo;


    public List<WishItem> getWishesFromWishList(int wishlist_id) {
        return wishRepo.getWishesFromWishList(wishlist_id);
    }



}