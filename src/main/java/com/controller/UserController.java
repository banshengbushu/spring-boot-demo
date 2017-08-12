package com.controller;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import javax.xml.ws.Response;
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

    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUsers() {
        List<User> users = repository.findAll();
        return users;
    }

    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getUserName(@RequestParam("id") int id) {
        List<User> users = repository.findAll();
        String userName = users.get(id).name;
        return userName;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        repository.save(user);
        return new User();
    }
}
