package com.example.demo.domain.user.service;

import com.example.demo.domain.user.controller.UserErrorStatus;
import com.example.demo.domain.user.dto.request.CreateUser;
import com.example.demo.domain.user.dto.request.UpdateUser;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandService {

    private final UserRepository userRepository;

    @Transactional
    public void joinUser(CreateUser createUser) {
        if (userRepository.existsByEmail(createUser.email()))
            throw new GeneralException(UserErrorStatus.USER_EMAIL_CONFLICT);

        User user = UserMapper.toEntity(createUser);
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user, UpdateUser updateUser) {
        if (!user.getEmail().equals(updateUser.email()) && userRepository.existsByEmail(updateUser.email()))
            throw new GeneralException(UserErrorStatus.USER_EMAIL_CONFLICT);

        user.update(updateUser);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(User user) {
        user.delete();
        userRepository.save(user);
    }

    @Transactional
    public void hardDeleteUser(User user) {
        userRepository.delete(user);
    }
}
