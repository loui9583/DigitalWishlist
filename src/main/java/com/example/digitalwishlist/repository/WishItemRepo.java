package com.example.digitalwishlist.repository;

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


    /*
public void addWishToWishList(WishItem wish) {
        String sql = "INSERT INTO wish (wishlist_id, item_id) VALUES (?, ?)";
        template.update(sql, wish.getWishlist_id(), wish.getItem_id());
    }*/

    public List<WishItem> getWishesFromWishList(int wishlist_id) {
        String sql = "SELECT * FROM wish JOIN item ON wish.item_id = item.item_id WHERE wish.wishlist_id = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(WishItem.class), wishlist_id);
    }

}
