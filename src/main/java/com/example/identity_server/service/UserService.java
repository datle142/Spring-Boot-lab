package com.example.identity_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.identity_server.dto.request.UserCreationRequest;
import com.example.identity_server.dto.request.UserUpdateRequest;
import com.example.identity_server.dto.response.UserResponse;
import com.example.identity_server.entity.user;
import com.example.identity_server.exception.AppException;
import com.example.identity_server.exception.ErrorCode;
import com.example.identity_server.mapper.UserMapper;
import com.example.identity_server.reponsitory.UserReponsitory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
     UserReponsitory userReponsitory;
     UserMapper userMapper;

    public user creatUser(UserCreationRequest request){
        if (userReponsitory.existsByusername(request.getUsername()))throw new AppException(ErrorCode.USER_EXISTED);

        user uSer = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        uSer.setPassword(passwordEncoder.encode(request.getPassword()));
        return userReponsitory.save(uSer);
    }

    //get all user
    public List<user> getUsers(){
        return userReponsitory.findAll();
    }

    //get user by id
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userReponsitory.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy user")));    
    }
    
    public UserResponse updateUser(String userid,UserUpdateRequest request ) {
        user uSer = userReponsitory.findById(userid).orElseThrow(()-> new RuntimeException("Không update user thành công"));
        userMapper.updateUser(uSer, request);

        return userMapper.toUserResponse(userReponsitory.save(uSer));
    }

    public void delUser(String userId){
        userReponsitory.deleteById(userId);
    }

}
