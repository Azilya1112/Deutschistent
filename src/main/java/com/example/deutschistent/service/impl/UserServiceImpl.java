package com.example.deutschistent.service.impl;

import com.example.deutschistent.dto.request.SignInRequest;
import com.example.deutschistent.dto.response.SignInResponse;
import com.example.deutschistent.entity.User;
import com.example.deutschistent.exceptions.AlreadyExistException;
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
        if(userRepository.findUserByUsername(user.getUserName()).isPresent()) {
            throw new AlreadyExistException("Already exist");
        }
        return userRepository.save(user);
    }
    @Override
    public User updateUser(Long id) {
//        User user= (id);
//        user.setUserName(user.getUserName());
//        user.setPassword(user.getPassword());
//        user.setEmail(user.getEmail());
//        return userRepository.save(user);
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName).orElseThrow(() -> new NotFoundException("User not found"));
    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
