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

        User user = UserMapper.toUser(req);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, UserUpdateReq req) {
        if (!user.getEmail().equals(req.email()) && userRepository.existsByEmail(req.email()))
            throw new GeneralException(UserErrorStatus.USER_EMAIL_CONFLICT);

        user.update(req);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        user.delete();
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void hardDeleteUser(User user) {
        userRepository.delete(user);
    }
}
