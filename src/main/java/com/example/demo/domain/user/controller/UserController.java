package com.example.demo.domain.user.controller;

import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.CommonSuccessStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping("")
    public ApiPayload<?> createUser() {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @GetMapping("")
    public ApiPayload<?> getUser() {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PutMapping("")
    public ApiPayload<?> updateUser() {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("")
    public ApiPayload<?> deleteUser() {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/hard")
    public ApiPayload<?> hardDeleteUser() {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
