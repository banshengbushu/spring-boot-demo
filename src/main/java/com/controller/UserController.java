package com.controller;

import com.model.User;
import com.repository.UserRepository;
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

    @RequestMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getUsers(Model model) {
        ModelAndView modelAndView = new ModelAndView("demo");
        List users = repository.findAll();
        modelAndView.addObject("age", ((User) users.get(0)).age);
        return modelAndView;
    }

    @RequestMapping("/chat")
    @ResponseStatus(HttpStatus.OK)
    public String home() {
        return "chat";      ///if don't use thymeleaf??
    }

    @RequestMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUser(@RequestParam Integer id) {
        String userId = id.toString();
        return repository.findById(userId);
    }

    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Object getUser() {
        List user = repository.findAll();
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        repository.save(user);
    }
}
