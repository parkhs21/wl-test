package com.example.demo.domain.user;

import com.example.demo.domain.user.entity.User;

public class UserFixture {

    public static User user() {
        return new User("name", "email");
    }

    public static User user(String email) {
        return new User("name", email);
    }
}
