package com.controller;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;
    private UserService userService;

    @RequestMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getUsers(Model model) {
        ModelAndView modelAndView = new ModelAndView("demo");
        List<User> users = repository.findAll();
        modelAndView.addObject("name", users.get(0).name);
        return modelAndView;
    }

    @RequestMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    User getUser(@RequestParam String id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUsers() {
        List<User> users = repository.findAll();
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
