package com.example.feign.service;

import com.example.feign.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private Map<Integer, User> userMap = new ConcurrentHashMap<>();

    public List<User> getUser() {
        return new ArrayList<>(this.userMap.values());
    }

    public User getUser(int id) {
        User user = this.userMap.get(id);
        if (user == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User addUser(User user) {
        if (this.userMap.containsKey(user.getId())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        this.userMap.put(user.getId(), user);
        return user;
    }
}
