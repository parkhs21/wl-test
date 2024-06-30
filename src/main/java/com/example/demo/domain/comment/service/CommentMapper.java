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

    public static Comment toComment(Board board, User writer, CreateComment createComment) {
        return Comment.builder()
                .board(board)
                .writer(writer)
                .content(createComment.content())
                .build();
    }

    public static GetComment toCommentGetRes(Comment comment) {
        return GetComment.builder()
                .id(comment.getId())
                .boardId(comment.getBoard().getId())
                .content(comment.getContent())
                .writer(UserMapper.toUserGetRes(comment.getWriter()))
//                .likeCount(comment.getLikeCount())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static List<GetComment> toCommentGetResList(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::toCommentGetRes)
                .collect(Collectors.toList());
    }
}
