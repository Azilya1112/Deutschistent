package com.example.deutschistent.service;

import com.example.deutschistent.entity.User;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService {

    User createUser(User user);
    void deleteUser(Long id);
    User findUserByUsername(Long id);
    User updateUser(Long id);
    List<User> findAllUsers();
}
