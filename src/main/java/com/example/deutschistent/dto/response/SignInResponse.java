package com.example.deutschistent.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignInResponse {

    private Long id;
    private String email;
    private String userName;
}
