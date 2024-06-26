package com.example.demo.domain.user.service.impl;

import com.example.demo.domain.user.controller.UserErrorStatus;
import com.example.demo.domain.user.dto.request.UserCreateReq;
import com.example.demo.domain.user.dto.request.UserUpdateReq;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.domain.user.service.UserCommandService;
import com.example.demo.domain.user.service.UserMapper;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void joinUser(UserCreateReq req) {
        if (userRepository.existsByEmail(req.email()))
            throw new GeneralException(UserErrorStatus.USER_EMAIL_CONFLICT);

        User newUser = UserMapper.toUser(req);
        userRepository.save(newUser);
    }

    @Override
    @Transactional
    public void updateUser(User selectedUser, UserUpdateReq req) {
        if (!selectedUser.getEmail().equals(req.email()) && userRepository.existsByEmail(req.email()))
            throw new GeneralException(UserErrorStatus.USER_EMAIL_CONFLICT);

        selectedUser.update(req.name(), req.email());
        userRepository.save(selectedUser);
    }

    @Override
    @Transactional
    public void deleteUser(User selectedUser) {
        selectedUser.delete();
        userRepository.save(selectedUser);
    }

}
