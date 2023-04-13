package com.example.digitalwishlist.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishRepo {

    @Autowired
    JdbcTemplate template;

    public void addWishToWishList(int wishlist_id, int item_id) {
        String sql = "INSERT INTO wish (wishlist_id, item_id, is_reserved) VALUES (?, ?, ?)";
        template.update(sql, wishlist_id, item_id, false);
    }


}
