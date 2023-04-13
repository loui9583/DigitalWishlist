package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.Wish;
import com.example.digitalwishlist.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishRepo wishRepo;

    public void addWishToWishList(Wish wish) {
    }
    public List<Wish> getWishesFromWishList(int wishlist_id) {
        return wishRepo.getWishesFromWishList(wishlist_id);
    }


}