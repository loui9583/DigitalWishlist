package com.example.digitalwishlist.repository;
import com.example.digitalwishlist.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepo {

    @Autowired
    JdbcTemplate template;

    public void generateWishList(WishList wishList){
        String sql = "INSERT INTO wishlist (wishlist_id, user_id, wishlist_name) VALUES(?,?,?)";
        template.update(sql, wishList.getWishList_id(), wishList.getUser_id(), wishList.getWishList_name());
    }
}
