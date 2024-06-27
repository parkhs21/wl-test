package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.controller.docs.BoardControllerDocs;
import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.dto.request.BoardUpdateReq;
import com.example.demo.domain.board.dto.response.BoardGetRes;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.service.BoardCommandService;
import com.example.demo.domain.board.service.BoardMapper;
import com.example.demo.domain.board.service.BoardQueryService;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserQueryService;
import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.CommonSuccessStatus;
import com.example.demo.global.payload.PagePayload;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController implements BoardControllerDocs {

    private final UserQueryService userQueryService;
    private final BoardQueryService boardQueryService;
    private final BoardCommandService boardCommandService;

    @PostMapping("")
    public ApiPayload<?> createBoard(@RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardCreateReq req) {
        User writer = userQueryService.getUser(userId);
        boardCommandService.createBoard(writer, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("/{board_id}")
    public ApiPayload<BoardGetRes> getBoard(@PathVariable("board_id") Long boardId) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, BoardMapper.toBoardGetRes(selectedBoard));
    }

    @GetMapping("")
    public PagePayload<BoardGetRes> getBoards(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<Board> boards = boardQueryService.getBoards(pageable);
        return PagePayload.onSuccess(CommonSuccessStatus.OK, BoardMapper.toBoardsGetRes(boards));
    }

    @PutMapping("/{board_id}")
    public ApiPayload<?> updateBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardUpdateReq req) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        boardCommandService.updateBoard(selectedBoard, userId, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{board_id}")
    public ApiPayload<?> deleteBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        boardCommandService.deleteBoard(selectedBoard, userId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PostMapping("/{board_id}/like")
    public ApiPayload<?> likeBoard(@PathVariable("board_id") Long boardId,
                                   @RequestParam("user_id") Long userId) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        User selectedUser = userQueryService.getUser(userId);
        boardCommandService.likeBoard(selectedBoard, selectedUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @DeleteMapping("/{board_id}/like")
    public ApiPayload<?> unlikeBoard(@PathVariable("board_id") Long boardId,
                                     @RequestParam("user_id") Long userId) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        User selectedUser = userQueryService.getUser(userId);
        boardCommandService.unlikeBoard(selectedBoard, selectedUser);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
