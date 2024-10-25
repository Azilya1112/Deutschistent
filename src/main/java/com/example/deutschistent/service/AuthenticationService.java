package com.example.deutschistent.service;

import com.example.deutschistent.dto.request.SignInRequest;
import com.example.deutschistent.dto.request.SignUpRequest;
import com.example.deutschistent.dto.response.SignInResponse;
import com.example.deutschistent.dto.response.SignUpResponse;

public interface AuthenticationService {
    SignInResponse signIn(SignInRequest signInRequest);
    SignUpResponse signUp(SignUpRequest signUpRequest);
}
