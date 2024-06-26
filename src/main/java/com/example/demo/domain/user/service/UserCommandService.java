package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.request.UserCreateReq;

public interface UserCommandService {
    void joinUser(UserCreateReq req);
}
