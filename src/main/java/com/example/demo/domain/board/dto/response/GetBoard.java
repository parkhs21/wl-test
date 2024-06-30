package com.example.demo.domain.board.dto.response;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.domain.comment.service.CommentMapper;
import com.example.demo.domain.user.dto.response.GetUser;
import com.example.demo.domain.user.service.UserMapper;

import java.time.LocalDateTime;
import java.util.List;

public record GetBoard(
        Long id,
        String title,
        String content,
        GetUser writer,
        Integer likeCount,
        List<CommentGetRes> comments,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public GetBoard(Board board) {
        this(board.getId(), board.getTitle(), board.getContent(), UserMapper.toUserGetRes(board.getWriter()), board.getLikeCount(), CommentMapper.toCommentGetResList(board.getComments()), board.getCreatedAt(), board.getUpdatedAt());
    }
}
