package com.example.demo.domain.board.controller.docs;

import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.dto.request.UpdateBoard;
import com.example.demo.domain.board.dto.response.GetBoard;
import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.PagePayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Board", description = "Board(게시글) 관련 API입니다.")
public interface BoardControllerDocs {

    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.")
    public ApiPayload<?> createBoard(@RequestParam("user_id") long userId,
                                     @Valid @RequestBody CreateBoard req);

    @Operation(summary = "게시글 조회", description = "게시글의 정보를 조회합니다.")
    public ApiPayload<GetBoard> getBoard(@PathVariable("board_id") long boardId);

    @Operation(summary = "게시글 페이징 조회", description = "게시글의 리스트를 페이징 조회합니다.")
    public PagePayload<GetBoard> getBoards(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size);

    @Operation(summary = "게시글 수정", description = "게시글의 정보를 수정합니다.")
    public ApiPayload<?> updateBoard(@PathVariable("board_id") long boardId,
                                     @RequestParam("user_id") long userId,
                                     @Valid @RequestBody UpdateBoard req);

    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    public ApiPayload<?> deleteBoard(@PathVariable("board_id") long boardId,
                                     @RequestParam("user_id") long userId);

    @Operation(summary = "게시글 좋아요", description = "게시글에 좋아요 표시합니다.")
    public ApiPayload<?> likeBoard(@PathVariable("board_id") long boardId,
                                   @RequestParam("user_id") long userId);

    @Operation(summary = "게시글 좋아요 취소", description = "게시글에 좋아요 표시를 취소합니다.")
    public ApiPayload<?> unlikeBoard(@PathVariable("board_id") long boardId,
                                     @RequestParam("user_id") long userId);
}
