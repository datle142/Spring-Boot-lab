package com.example.identity_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.identity_server.dto.UserCreationRequest;
import com.example.identity_server.entity.user;
import com.example.identity_server.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    user createUser(@RequestBody UserCreationRequest request){
        userService.creatUser(request);
    }
}
