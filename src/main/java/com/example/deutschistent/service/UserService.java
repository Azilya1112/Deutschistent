package com.example.deutschistent.service;

import com.example.deutschistent.dto.request.SignInRequest;
import com.example.deutschistent.dto.response.SignInResponse;
import com.example.deutschistent.entity.User;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService {

    User createUser(User user);
    void deleteUser(Long id);
    User findUserByUsername(String userName);
    User updateUser(Long id);
    List<User> findAllUsers();
}
