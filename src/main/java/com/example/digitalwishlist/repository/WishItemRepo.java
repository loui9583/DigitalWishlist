package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.Wish;
import com.example.digitalwishlist.model.WishItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishItemRepo {

    @Autowired
    JdbcTemplate template;

    public List<WishItem> getWishesFromWishlist(int wishlist_id){
        String sql = "SELECT * FROM wish JOIN item ON wish.item_id = item.item_id WHERE wish.wishlist_id = ? ORDER BY wish.wish_id DESC";
        return template.query(sql, new BeanPropertyRowMapper<>(WishItem.class), wishlist_id);
    }

}
