package com.example.deutschistent.controller;


import com.example.deutschistent.entity.User;
import com.example.deutschistent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable long id){
        return userService.updateUser(id);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
