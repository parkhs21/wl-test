package com.example.demo.domain.comment.controller;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.service.BoardQueryService;
import com.example.demo.domain.comment.controller.docs.CommentControllerDocs;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.request.CommentUpdateReq;
import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.domain.comment.service.CommentCommandService;
import com.example.demo.domain.comment.service.CommentQueryService;
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
@RequestMapping("/api/v1/comment")
public class CommentController implements CommentControllerDocs {

    private final UserQueryService userQueryService;
    private final BoardQueryService boardQueryService;
    private final CommentQueryService commentQueryService;
    private final CommentCommandService commentCommandService;

    @PostMapping("")
    public ApiPayload<?> createComment(@RequestParam("user_id") Long userId,
                                       @Valid @RequestBody CommentCreateReq req) {
        Board selectedBoard = boardQueryService.getBoard(req.boardId());
        User writer = userQueryService.getUser(userId);
        commentCommandService.createComment(selectedBoard, writer, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("/{comment_id}")
    public ApiPayload<CommentGetRes> getComment(@PathVariable("comment_id") Long commentId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PutMapping("/{comment_id}")
    public ApiPayload<?> updateComment(@PathVariable("comment_id") Long commentId,
                                       @RequestParam("user_id") Long userId,
                                       @Valid @RequestBody CommentUpdateReq req) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{comment_id}")
    public ApiPayload<?> deleteComment(@PathVariable("comment_id") Long commentId,
                                       @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @PostMapping("/{comment_id}/like")
    public ApiPayload<?> likeComment(@PathVariable("comment_id") Long commentId,
                                     @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{comment_id}/like")
    public ApiPayload<?> unlikeComment(@PathVariable("comment_id") Long commentId,
                                       @RequestParam("user_id") Long userId) {
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }
}
