package com.example.demo.domain.comment.controller.docs;

import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.request.CommentUpdateReq;
import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.global.payload.ApiPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Comment", description = "Comment(댓글) 관련 API입니다.")
public interface CommentControllerDocs {
    @Operation(summary = "댓글 생성", description = "새로운 댓글을 생성합니다.")
    public ApiPayload<?> createComment(@PathVariable long boardId,
                                       @RequestParam long userId,
                                       @Valid @RequestBody CommentCreateReq req);

    @Operation(summary = "댓글 조회", description = "댓글의 정보를 조회합니다.")
    public ApiPayload<CommentGetRes> getComment(@PathVariable long boardId,
                                                @PathVariable long commentId);

    @Operation(summary = "댓글 수정", description = "댓글의 정보를 수정합니다.")
    public ApiPayload<?> updateComment(@PathVariable long boardId,
                                       @PathVariable long commentId,
                                       @RequestParam("userId") long userId,
                                       @Valid @RequestBody CommentUpdateReq req);

    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    public ApiPayload<?> deleteComment(@PathVariable long boardId,
                                       @PathVariable long commentId,
                                       @RequestParam("userId") long userId);

    @Operation(summary = "댓글 좋아요", description = "댓글에 좋아요 표시합니다.")
    public ApiPayload<?> likeComment(@PathVariable long boardId,
                                     @PathVariable long commentId,
                                     @RequestParam("userId") long userId);

    @Operation(summary = "댓글 좋아요 취소", description = "댓글에 좋아요 표시를 취소합니다.")
    public ApiPayload<?> unlikeComment(@PathVariable long boardId,
                                       @PathVariable long commentId,
                                       @RequestParam("userId") long userId);
}
