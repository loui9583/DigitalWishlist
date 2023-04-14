package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepo {

   @Autowired
    JdbcTemplate template;


   public void addItem(int item_name, int item_price){
       String sql = "INSERT INTO item (item_name, item_price) VALUES (?, ?)";
       template.update(sql, item_name, item_price);
   }

   public List<Item> getItems(){
       String sql = "SELECT * FROM item";
       return template.query(sql, new BeanPropertyRowMapper<>(Item.class));
   }

   public int getNewestItemId(){
       String sql = "SELECT item_id FROM item ORDER BY item_id DESC limit 1";
       //sql henter int(det sidst tilføjede item) fra WB og returnerer det som en integer klasse
       return template.queryForObject(sql, Integer.class);
   }



}
