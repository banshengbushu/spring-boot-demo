package com.service;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List getUsers() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            return users;
        }
        return users;
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public User getUserById(String id) {
        List<User> users = repository.findById(id);
        for (User user : users) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
}
