package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.request.UserCreateReq;
import com.example.demo.domain.user.dto.request.UserUpdateReq;
import com.example.demo.domain.user.entity.User;

public interface UserCommandService {
    void joinUser(UserCreateReq req);
    void updateUser(User user, UserUpdateReq req);
    void deleteUser(User user);
    void hardDeleteUser(User user);
}
