package com.example.deutschistent.service.impl;

import com.example.deutschistent.dto.request.SignInRequest;
import com.example.deutschistent.dto.request.SignUpRequest;
import com.example.deutschistent.dto.response.SignInResponse;
import com.example.deutschistent.dto.response.SignUpResponse;
import com.example.deutschistent.entity.User;
import com.example.deutschistent.exceptions.NotFoundException;
import com.example.deutschistent.repositories.UserRepository;
import com.example.deutschistent.service.AuthenticationService;
import com.example.deutschistent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findUserByEmailAndPassword(signInRequest.getEmail(), signInRequest.getPassword()).orElseThrow(() -> new NotFoundException("Not found!"));
        return SignInResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .build();
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUserName(signUpRequest.getUserName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        userService.createUser(user);
        return SignUpResponse.builder()
                .id(user.getId())
                .build();
    }
}
