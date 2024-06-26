package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.controller.docs.BoardControllerDocs;
import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.dto.request.BoardUpdateReq;
import com.example.demo.domain.board.dto.response.BoardGetRes;
import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.CommonSuccessStatus;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController implements BoardControllerDocs {
    @PostMapping("")
    public ApiPayload<?> createBoard(@RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardCreateReq req) {
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("/{board_id}")
    public ApiPayload<BoardGetRes> getBoard(@PathVariable("board_id") Long boardId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PutMapping("/{board_id}")
    public ApiPayload<?> updateBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardUpdateReq req) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{board_id}")
    public ApiPayload<?> deleteBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PostMapping("/{board_id}/like")
    public ApiPayload<?> likeBoard(@PathVariable("board_id") Long boardId,
                                   @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{board_id}/like")
    public ApiPayload<?> unlikeBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
