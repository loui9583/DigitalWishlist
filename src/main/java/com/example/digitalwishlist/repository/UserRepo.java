package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate template;


    public void addUser(User user){
        String sql = "INSERT INTO user (user_id, user_name, user_password, user_email) VALUES(?,?,?,?)";
        template.update(sql,user.getUser_id(),user.getUser_name(), user.getUser_password(), user.getUser_email());
    }

    public User logIn(String user_name, String user_password){
        String sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
        try {
            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
            User user = template.queryForObject(sql, rowMapper, user_name, user_password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }




}
