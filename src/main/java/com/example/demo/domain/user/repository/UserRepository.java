package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    Optional<User> findByIdAndStatus(Long id, UserStatus status);
}
