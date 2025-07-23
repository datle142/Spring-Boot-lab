package com.example.identity_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.identity_server.dto.ApiResponse;
import com.example.identity_server.dto.UserCreationRequest;
import com.example.identity_server.dto.UserUpdateRequest;
import com.example.identity_server.entity.user;
import com.example.identity_server.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<user> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<user> apiResponse = new ApiResponse<>();
        
        apiResponse.setResult(userService.creatUser(request));
        return apiResponse;
    }

    @GetMapping
    List<user> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    user getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }
    
    @PutMapping("/{userId}")
    user updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String delUser(@PathVariable String userId){
        userService.delUser(userId);
        return "đã xóa user ";
    }
    
}
