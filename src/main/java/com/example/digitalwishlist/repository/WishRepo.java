package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class WishRepo {

    @Autowired
    JdbcTemplate template;


    public List<Wish> getWishesFromWishList(int wishlist_id) {
        String sql = "SELECT * FROM wish JOIN item ON wish.item_id = item.item_id WHERE wish.wishlist_id = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(Wish.class), wishlist_id);
    }

}
