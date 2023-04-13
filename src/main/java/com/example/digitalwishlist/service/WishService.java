package com.example.digitalwishlist.service;

import com.example.digitalwishlist.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    WishRepo wishRepo;

    public void addWishToWishList(int wishlist_id, int item_id) {
        wishRepo.addWishToWishList(wishlist_id, item_id);
    }

}
