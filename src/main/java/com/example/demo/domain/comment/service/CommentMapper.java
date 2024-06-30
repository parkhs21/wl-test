package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CreateComment;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;

public class CommentMapper {

    public static Comment toEntity(Board board, User writer, CreateComment createComment) {
        return new Comment(createComment.content(), writer, board);
    }
}
