package com.example.demo.domain.user.controller.docs;

import com.example.demo.domain.user.dto.request.CreateUser;
import com.example.demo.domain.user.dto.request.UpdateUser;
import com.example.demo.domain.user.dto.response.GetUser;
import com.example.demo.global.payload.ApiPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "User", description = "User 관련 API입니다.")
public interface UserControllerDocs {

    @Operation(summary = "유저 생성", description = "새로운 유저를 생성합니다.")
    public ApiPayload<?> createUser(@Valid @RequestBody CreateUser req);

    @Operation(summary = "유저 정보 조회", description = "유저의 정보를 조회합니다.")
    public ApiPayload<GetUser> getUser(@RequestParam("id") Long id);

    @Operation(summary = "유저 정보 수정", description = "유저의 정보를 수정합니다.")
    public ApiPayload<?> updateUser(@RequestParam("id") Long id,
                                    @Valid @RequestBody UpdateUser req);

    @Operation(summary = "유저 삭제(soft)", description = "유저를 soft delete로 삭제합니다.")
    public ApiPayload<?> deleteUser(@RequestParam("id") Long id);

    @Operation(summary = "유저 삭제(hard)", description = "유저를 hard delete로 삭제합니다.")
    public ApiPayload<?> hardDeleteUser(@RequestParam("id") Long id);
}
