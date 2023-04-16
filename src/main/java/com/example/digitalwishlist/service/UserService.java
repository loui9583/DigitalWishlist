package com.example.digitalwishlist.service;


import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.model.WishList;
import com.example.digitalwishlist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getUser(int user_id) {
        return userRepo.getUser(user_id);
    }

    public void addUser(User user) {
        userRepo.addUser(user);
    }

    public User logIn(String user_name, String user_password) {
        return userRepo.logIn(user_name, user_password);
    }



}
