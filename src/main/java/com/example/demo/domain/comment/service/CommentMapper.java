package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;

public class CommentMapper {

    public static Comment toComment(Board selectedBoard, User writer, CommentCreateReq req) {
        return Comment.builder()
                .board(selectedBoard)
                .writer(writer)
                .content(req.content())
                .build();
    }
}
