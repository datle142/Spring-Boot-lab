package com.example.identity_server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.identity_server.dto.request.UserCreationRequest;
import com.example.identity_server.dto.request.UserUpdateRequest;
import com.example.identity_server.dto.response.UserResponse;
import com.example.identity_server.entity.user;

@Mapper(componentModel = "spring")
public interface UserMapper {
    user toUser(UserCreationRequest request);
    UserResponse toUserResponse(user uSer);
    void updateUser(@MappingTarget user uSer, UserUpdateRequest request);
}
