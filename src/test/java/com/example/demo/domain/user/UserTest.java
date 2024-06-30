package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.request.UpdateUser;
import com.example.demo.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    @DisplayName("Update DTO 로 update 되는 지 확인")
    void update() {
        // given
        User user = UserFixture.user();
        UpdateUser updateUser = new UpdateUser("updateName", "updateEmail");

        // when
        user.update(updateUser);

        // then
        assertEquals(updateUser.name(), user.getName());
        assertEquals(updateUser.email(), user.getEmail());
    }
}
