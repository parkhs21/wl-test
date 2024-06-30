package com.example.demo.domain.comment.controller;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.service.BoardQueryService;
import com.example.demo.domain.comment.controller.docs.CommentControllerDocs;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.request.CommentUpdateReq;
import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.service.CommentCommandService;
import com.example.demo.domain.comment.service.CommentMapper;
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
@RequestMapping("/api/v1/boards/{boardId}/comments")
public class CommentController implements CommentControllerDocs {

    private final UserQueryService userQueryService;
    private final BoardQueryService boardQueryService;
    private final CommentQueryService commentQueryService;
    private final CommentCommandService commentCommandService;

    @PostMapping("")
    public ApiPayload<Void> createComment(@PathVariable long boardId,
                                          @RequestParam long userId,
                                          @Valid @RequestBody CommentCreateReq req) {
        Board selectedBoard = boardQueryService.getBoard(boardId);
        User writer = userQueryService.getUser(userId);
        commentCommandService.createComment(selectedBoard, writer, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.CREATED, null);
    }

    @GetMapping("/{commentId}")
    public ApiPayload<CommentGetRes> getComment(@PathVariable long boardId,
                                                @PathVariable long commentId) {
        Comment selectedComment = commentQueryService.getComment(boardId, commentId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, CommentMapper.toCommentGetRes(selectedComment));
    }

    @PutMapping("/{commentId}")
    public ApiPayload<Void> updateComment(@PathVariable long boardId,
                                          @PathVariable long commentId,
                                          @RequestParam("userId") long userId,
                                          @Valid @RequestBody CommentUpdateReq req) {
        Comment selectedComment = commentQueryService.getComment(boardId, commentId);
        commentCommandService.updateComment(selectedComment, userId, req);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

    @DeleteMapping("/{commentId}")
    public ApiPayload<Void> deleteComment(@PathVariable long boardId,
                                          @PathVariable long commentId,
                                          @RequestParam("userId") long userId) {
        Comment selectedComment = commentQueryService.getComment(boardId, commentId);
        commentCommandService.deleteComment(selectedComment, userId);
        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
    }

//    @PostMapping("/{commentId}/like")
//    public ApiPayload<Void> likeComment(@PathVariable long boardId,
//                                        @PathVariable long commentId,
//                                        @RequestParam("userId") long userId) {
//        Comment selectedComment = commentQueryService.getComment(boardId, commentId);
//        User selectedUser = userQueryService.getUser(userId);
//        commentCommandService.likeComment(selectedComment, selectedUser);
//        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
//    }
//
//    @DeleteMapping("/{commentId}/like")
//    public ApiPayload<Void> unlikeComment(@PathVariable long boardId,
//                                          @PathVariable long commentId,
//                                          @RequestParam("userId") long userId) {
//        Comment selectedComment = commentQueryService.getComment(boardId, commentId);
//        User selectedUser = userQueryService.getUser(userId);
//        commentCommandService.unlikeComment(selectedComment, selectedUser);
//        return ApiPayload.onSuccess(CommonSuccessStatus.OK, null);
//    }
}
