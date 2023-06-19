package com.example.demo.service;

import com.example.demo.eneity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService{
    void add(User user);

    void updateById(User user);

    void deletedById(Long id);

    User findUser(User user);

    User findById(String id);

    List<User> getAll();

}
