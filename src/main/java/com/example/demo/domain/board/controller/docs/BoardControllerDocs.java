package com.example.demo.domain.board.controller.docs;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.dto.request.BoardUpdateReq;
import com.example.demo.domain.board.dto.response.BoardGetRes;
import com.example.demo.global.payload.ApiPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Board", description = "Board(게시글) 관련 API입니다.")
public interface BoardControllerDocs {

    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.")
    public ApiPayload<?> createBoard(@RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardCreateReq req);

    @Operation(summary = "게시글 조회", description = "게시글의 정보를 조회합니다.")
    public ApiPayload<BoardGetRes> getBoard(@PathVariable("id") Long id);

    @Operation(summary = "게시글 수정", description = "게시글의 정보를 수정합니다.")
    public ApiPayload<?> updateBoard(@PathVariable("id") Long id,
                                     @RequestParam("user_id") Long userId,
                                     @Valid @RequestBody BoardUpdateReq req);

    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    public ApiPayload<?> deleteBoard(@PathVariable("id") Long id,
                                     @RequestParam("user_id") Long userId);

    @Operation(summary = "게시글 좋아요", description = "게시글에 좋아요 표시합니다.")
    public ApiPayload<?> likeBoard(@PathVariable("id") Long id,
                                   @RequestParam("user_id") Long userId);

    @Operation(summary = "게시글 좋아요 취소", description = "게시글에 좋아요 표시를 취소합니다.")
    public ApiPayload<?> unlikeBoard(@PathVariable("id") Long id,
                                     @RequestParam("user_id") Long userId);
}
