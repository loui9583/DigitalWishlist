package com.example.digitalwishlist.repository;
import com.example.digitalwishlist.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepo {

    @Autowired
    JdbcTemplate template;

    public void generateWishList(WishList wishList){
        String sql = "INSERT INTO wishlist (wishlist_id, user_id, wishlist_name) VALUES(?,?,?)";
        template.update(sql, wishList.getWishList_id(), wishList.getUser_id(), wishList.getWishList_name());
    }

   public List<WishList> getUserWishLists(int user_id) {
       String sql = "SELECT * FROM wishlist WHERE user_id = ?";
       return template.query(sql, new BeanPropertyRowMapper<>(WishList.class), user_id);
   }

   public WishList getWishList(int wishlist_id) {
       String sql = "SELECT * FROM wishlist WHERE wishlist_id = ?";
       return template.queryForObject(sql, new BeanPropertyRowMapper<>(WishList.class), wishlist_id);
   }

}
