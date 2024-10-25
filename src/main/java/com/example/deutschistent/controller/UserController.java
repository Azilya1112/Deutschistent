package com.example.deutschistent.controller;


import com.example.deutschistent.dto.request.SignInRequest;
import com.example.deutschistent.dto.request.SignUpRequest;
import com.example.deutschistent.dto.response.SignInResponse;
import com.example.deutschistent.dto.response.SignUpResponse;
import com.example.deutschistent.entity.User;
import com.example.deutschistent.service.AuthenticationService;
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
    private final AuthenticationService authenticationService;

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

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }

    @PostMapping("/signUp")
    public SignUpResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }



}
