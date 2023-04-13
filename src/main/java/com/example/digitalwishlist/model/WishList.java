package com.example.digitalwishlist.model;

public class WishList {

    private int wishList_id;
    private int user_id;
    private String wishList_name;

    public WishList(){

    }

    public int getWishList_id() {
        return wishList_id;
    }

    public void setWishList_id(int wishList_id) {
        this.wishList_id = wishList_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getWishList_name() {
        return wishList_name;
    }

    public void setWishList_name(String wishList_name) {
        this.wishList_name = wishList_name;
    }
}
