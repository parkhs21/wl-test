package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.request.CreateUser;
import com.example.demo.domain.user.entity.User;

public class UserMapper {
    public static User toEntity(CreateUser req) {
        return new User(req.name(), req.email());
    }
}
