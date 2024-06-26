package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.controller.docs.UserControllerDocs;
import com.example.demo.domain.user.dto.request.UserCreateReq;
import com.example.demo.domain.user.dto.request.UserUpdateReq;
import com.example.demo.domain.user.dto.response.UserGetRes;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserCommandService;
import com.example.demo.domain.user.service.UserMapper;
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
public class UserController implements UserControllerDocs {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    @PostMapping("")
    public ApiPayload<?> createUser(@Valid @RequestBody UserCreateReq req) {
        userCommandService.joinUser(req);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("")
    public ApiPayload<UserGetRes> getUser(@RequestParam("user_id") Long userId) {
        User selectedUser = userQueryService.getUser(userId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, UserMapper.toUserGetRes(selectedUser));
    }

    @PutMapping("")
    public ApiPayload<?> updateUser(@RequestParam("user_id") Long userId,
                                    @Valid @RequestBody UserUpdateReq req) {
        User selectedUser = userQueryService.getUser(userId);
        userCommandService.updateUser(selectedUser, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("")
    public ApiPayload<?> deleteUser(@RequestParam("user_id") Long userId) {
        User selectedUser = userQueryService.getUser(userId);
        userCommandService.deleteUser(selectedUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/hard-delete")
    public ApiPayload<?> hardDeleteUser(@RequestParam("user_id") Long userId) {
        User selectedUser = userQueryService.getInactiveUser(userId);
        userCommandService.hardDeleteUser(selectedUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
