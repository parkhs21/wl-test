package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.dto.request.CreateUser;
import com.example.demo.domain.user.dto.request.UpdateUser;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserCommandService;
import com.example.demo.domain.user.service.UserQueryService;
import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.CommonSuccessStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    @PostMapping("")
    public ApiPayload<?> createUser(@Valid @RequestBody CreateUser createUser) {
        userCommandService.joinUser(createUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @PutMapping("")
    public ApiPayload<?> updateUser(@RequestParam("user_id") Long userId,
                                    @Valid @RequestBody UpdateUser updateUser) {
        User user = userQueryService.getUser(userId);
        userCommandService.updateUser(user, updateUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("")
    public ApiPayload<?> deleteUser(@RequestParam("user_id") Long userId) {
        User user = userQueryService.getUser(userId);
        userCommandService.deleteUser(user);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/hard-delete")
    public ApiPayload<?> hardDeleteUser(@RequestParam("user_id") Long userId) {
        User user = userQueryService.getInactiveUser(userId);
        userCommandService.hardDeleteUser(user);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
