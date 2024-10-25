package com.example.deutschistent.service.impl;

import com.example.deutschistent.entity.User;
import com.example.deutschistent.exceptions.NotFoundException;
import com.example.deutschistent.repositories.UserRepository;
import com.example.deutschistent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User updateUser(Long id) {
        User user= findUserByUsername(id);
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User findUserByUsername(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
