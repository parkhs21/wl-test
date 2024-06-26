package com.example.demo.domain.user.service;

import com.example.demo.domain.user.entity.User;

public interface UserQueryService {
    User getUser(Long userId);
}
