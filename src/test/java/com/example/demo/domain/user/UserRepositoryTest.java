package com.example.demo.domain.user;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void existsByEmail() {
        // Given
        User user = UserFixture.user();
        userRepository.save(user);

        // When


        // Then
        assertTrue(userRepository.existsByEmail(user.getEmail()));
    }

    @Test
    void findByIdAndStatus() {
        // Given
        User user = UserFixture.user();
        userRepository.save(user);

        // When


        // Then
        assertEquals(user, userRepository.findByIdAndStatus(user.getId(), user.getStatus()).get());
    }
}
