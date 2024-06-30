package com.example.demo.domain.user.service;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.entity.UserStatus;
import com.example.demo.domain.user.exception.BadRequestUserException;
import com.example.demo.domain.user.exception.NotFoundUserException;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryService {

    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findByIdAndStatus(userId, UserStatus.ACTIVE)
                .orElseThrow(NotFoundUserException::new);
    }

    public User getInactiveUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);

        if (user.getStatus().equals(UserStatus.ACTIVE))
            throw new BadRequestUserException();

        return user;
    }
}
