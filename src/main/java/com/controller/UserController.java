package com.controller;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import javax.xml.ws.Response;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getUsers(Model model) {
        ModelAndView modelAndView = new ModelAndView("demo");
        List<User> users = userService.getUsers();

        modelAndView.addObject("name", users.get(0).name);
        return modelAndView;
    }

    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getUserName(@RequestParam("id") int id) {
        List<User> users = userService.getUsers();
        String userName = users.get(id).name;
        return userName;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<User> getUsers() {
        return userService.getUsers();
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User addUser(@RequestBody User user) {
//        return repository.save(user);
//    }

    @PostMapping("/users")
    public ResponseEntity<User> handle(HttpEntity<User> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        User requestBody = requestEntity.getBody();
        userService.addUser(requestBody);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyHeader");

        return new ResponseEntity<User>(requestBody, responseHeaders, HttpStatus.CREATED);
    }
}
