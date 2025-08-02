package com.example.identity_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.identity_server.dto.request.ApiResponse;
import com.example.identity_server.dto.request.AuthenticationRequest;
import com.example.identity_server.dto.response.AuthenticationResponse;
import com.example.identity_server.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthencicationController {
    AuthenticationService authenticationService;
    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request); 

        return ApiResponse.<AuthenticationResponse>builder().result(AuthenticationResponse.builder().authenticate(result).build()).build();

    }
    
}
