package com.example.identity_server.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.identity_server.dto.request.AuthenticationRequest;
import com.example.identity_server.exception.AppException;
import com.example.identity_server.exception.ErrorCode;
import com.example.identity_server.reponsitory.UserReponsitory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationService {
    UserReponsitory userReponsitory;
    public boolean authenticate(AuthenticationRequest request){
        var user = userReponsitory.findByUsername(request.getUsername()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        return passwordEncoder.matches(request.getPassword(),user.getPassword());
    }
}
