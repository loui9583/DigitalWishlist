package com.example.digitalwishlist.service;

import com.example.digitalwishlist.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    WishRepo wishRepo;


    public void addWish(int wishlist_id, int item_id){
        wishRepo.addWish(wishlist_id,item_id);
    }


}
