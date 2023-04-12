package com.example.digitalwishlist.service;


import com.example.digitalwishlist.model.User;
import com.example.digitalwishlist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void addUser(User user){
        userRepo.addUser(user);
    }

}
