package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.controller.docs.UserControllerDocs;
import com.example.demo.domain.user.dto.request.UserCreateReq;
import com.example.demo.domain.user.dto.request.UserUpdateReq;
import com.example.demo.domain.user.dto.response.UserGetRes;
import com.example.demo.domain.user.service.UserCommandService;
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

    private final UserCommandService userCommandService;

    @PostMapping("")
    public ApiPayload<?> createUser(@Valid @RequestBody UserCreateReq req) {
        userCommandService.joinUser(req);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("")
    public ApiPayload<UserGetRes> getUser(@RequestParam("id") Long id) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PutMapping("")
    public ApiPayload<?> updateUser(@RequestParam("id") Long id,
                                    @Valid @RequestBody UserUpdateReq req) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("")
    public ApiPayload<?> deleteUser(@RequestParam("id") Long id) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/hard-delete")
    public ApiPayload<?> hardDeleteUser(@RequestParam("id") Long id) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
