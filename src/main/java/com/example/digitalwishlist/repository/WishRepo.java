package com.example.digitalwishlist.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishRepo {

    @Autowired
    JdbcTemplate template;

    public void addWish(int wishlist_id, int item_id){
        String sql = "INSERT INTO wish (wishlist_id, item_id, is_reserved) VALUES (?, ?, ?)";
        template.update(sql, wishlist_id, item_id, false);
    }

    public void isReserved(int wish_id, boolean is_reserved) {
        String sql = "UPDATE wish SET is_reserved = ? WHERE  wish_id = ?";
        template.update(sql, is_reserved, wish_id);
    }

    public void deleteWish(int wish_id){
        String sql = "DELETE FROM wish WHERE wish_id = ?";
        template.update(sql, wish_id);
    }


}
