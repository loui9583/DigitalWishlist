package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.model.WishList;
import com.example.digitalwishlist.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    WishListRepo wishListRepo;

    public void generateWishList(WishList wishList){
        wishListRepo.generateWishList(wishList);
    }

}
