package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.dto.request.UpdateBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.service.BoardCommandService;
import com.example.demo.domain.board.service.BoardQueryService;
import com.example.demo.domain.user.entity.User;
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
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final UserQueryService userQueryService;
    private final BoardQueryService boardQueryService;
    private final BoardCommandService boardCommandService;

    @PostMapping("")
    public ApiPayload<Void> createBoard(@RequestParam("userId") long userId,
                                        @Valid @RequestBody CreateBoard createBoard) {
        User user = userQueryService.getUser(userId);
        boardCommandService.createBoard(user, createBoard);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @PutMapping("/{boardId}")
    public ApiPayload<Void> updateBoard(@PathVariable long boardId,
                                        @RequestParam("userId") long userId,
                                        @Valid @RequestBody UpdateBoard updateBoard) {
        Board board = boardQueryService.getBoard(boardId);
        boardCommandService.updateBoard(board, userId, updateBoard);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{boardId}")
    public ApiPayload<Void> deleteBoard(@PathVariable long boardId,
                                        @RequestParam("user_id") long userId) {
        Board board = boardQueryService.getBoard(boardId);
        boardCommandService.deleteBoard(board, userId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PostMapping("/{boardId}/like")
    public ApiPayload<Void> likeBoard(@PathVariable long boardId,
                                      @RequestParam("userId") long userId) {
        Board board = boardQueryService.getBoard(boardId);
        User user = userQueryService.getUser(userId);
        boardCommandService.likeBoard(board, user);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }
}
