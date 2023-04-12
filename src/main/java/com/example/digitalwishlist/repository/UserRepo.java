package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate template;


    public void addUser(User user){
        String sql = "INSERT INTO user (user_id, user_name, user_password, user_email) VALUES(?,?,?,?)";
        template.update(sql,user.getUser_id(),user.getUser_name(), user.getUser_password(), user.getUser_email());
    }


}
