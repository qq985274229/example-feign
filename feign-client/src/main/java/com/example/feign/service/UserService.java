package com.example.feign.service;

import com.example.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/feign/service/user")
@FeignClient(name = "feign-service")
public interface UserService {
    @GetMapping
    List<User> getUser();

    @GetMapping("/{id}")
    User getUser(@PathVariable int id);

    @PostMapping
    User addUser(User user);
}
