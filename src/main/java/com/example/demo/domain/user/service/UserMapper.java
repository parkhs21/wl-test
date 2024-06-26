package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.request.UserCreateReq;
import com.example.demo.domain.user.entity.User;

public class UserMapper {
    public static User toUser(UserCreateReq req) {
        return User.builder()
                .email(req.email())
                .name(req.name())
                .build();
    }
}
