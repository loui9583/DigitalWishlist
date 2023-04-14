package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.WishItem;
import com.example.digitalwishlist.repository.WishItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishItemService {

    @Autowired
    WishItemRepo wishItemRepo;

    public List<WishItem> getWishesFromWishlist(int wishlist_id){
        return wishItemRepo.getWishesFromWishlist(wishlist_id);
    }

}
