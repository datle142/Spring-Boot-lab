package com.example.identity_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.identity_server.dto.UserCreationRequest;
import com.example.identity_server.entity.user;
import com.example.identity_server.reponsitory.UserReponsitory;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public user creatUser(UserCreationRequest request){
        user uSer = new user();
        uSer.setUsername(request.getUsername());
        uSer.setPassword(request.getPassword());
        uSer.setFristname(request.getFristname());
        uSer.setLatename(request.getLatename());
        uSer.setDob(request.getDob());

        return userReponsitory.save(uSer);
    }
}
