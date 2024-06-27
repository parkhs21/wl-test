package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static Comment toComment(Board selectedBoard, User writer, CommentCreateReq req) {
        return Comment.builder()
                .board(selectedBoard)
                .writer(writer)
                .content(req.content())
                .build();
    }

    public static CommentGetRes toCommentGetRes(Comment comment) {
        return CommentGetRes.builder()
                .id(comment.getId())
                .boardId(comment.getBoard().getId())
                .content(comment.getContent())
                .writer(UserMapper.toUserGetRes(comment.getWriter()))
                .likeCount(comment.getLikeCount())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static List<CommentGetRes> toCommentGetResList(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::toCommentGetRes)
                .collect(Collectors.toList());
    }
}
