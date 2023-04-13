package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.WishList;
import com.example.digitalwishlist.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepo wishListRepo;

    public void generateWishList(WishList wishList){
        wishListRepo.generateWishList(wishList);
    }

    public List<WishList> getUserWishLists(int user_id){
       return wishListRepo.getUserWishLists(user_id);
    }

    public WishList getWishList(int wishlist_id) {
        return wishListRepo.getWishList(wishlist_id);
    }

}
