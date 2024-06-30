package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CreateComment;
import com.example.demo.domain.comment.dto.response.GetComment;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static Comment toEntity(Board board, User writer, CreateComment createComment) {
        return new Comment(createComment.content(), writer, board);
    }

    public static GetComment toCommentGetRes(Comment comment) {
        return new GetComment(comment);
    }

    public static List<GetComment> toCommentGetResList(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::toCommentGetRes)
                .collect(Collectors.toList());
    }
}
