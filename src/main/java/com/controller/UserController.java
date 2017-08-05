package com.controller;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUsers() {
        return repository.findAll();
    }

    @RequestMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUser(@RequestParam Integer id) {
        String userId = id.toString();
        return repository.findById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        repository.save(user);
    }
}
