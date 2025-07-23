package com.example.identity_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.identity_server.dto.UserCreationRequest;
import com.example.identity_server.dto.UserUpdateRequest;
import com.example.identity_server.entity.user;
import com.example.identity_server.exception.AppException;
import com.example.identity_server.exception.ErrorCode;
import com.example.identity_server.reponsitory.UserReponsitory;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public user creatUser(UserCreationRequest request){
        user uSer = new user();
        if (userReponsitory.existsByusername(request.getUsername()))throw new AppException(ErrorCode.USER_EXISTED);
        
        uSer.setUsername(request.getUsername());
        uSer.setPassword(request.getPassword());
        uSer.setFristname(request.getFristname());
        uSer.setLatename(request.getLatename());
        uSer.setDob(request.getDob());

        return userReponsitory.save(uSer);
    }

    //get all user
    public List<user> getUsers(){
        return userReponsitory.findAll();
    }

    //get user by id
    public user getUser(String id){
        return userReponsitory.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy user"));    
    }
    
    public user updateUser(String userid,UserUpdateRequest request ) {
        user uSer = getUser(userid);
        uSer.setPassword(request.getPassword());
        uSer.setFristname(request.getFristname());
        uSer.setLatename(request.getLatename());
        uSer.setDob(request.getDob());

        return userReponsitory.save(uSer);
    }

    public void delUser(String userId){
        userReponsitory.deleteById(userId);
    }

}
