package com.example.feign.controller;

import com.example.feign.entity.User;
import com.example.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign/service/user")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping
    public List<User> getUser() {
        return this.userService.getUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return this.userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }
}
