package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.request.CommentUpdateReq;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;

public interface CommentCommandService {
    void createComment(Board selectedBoard, User writer, CommentCreateReq req);
    void updateComment(Comment selectedComment, Long writerId, CommentUpdateReq req);
    void deleteComment(Comment selectedComment, Long userId);
    void likeComment(Comment selectedComment, User selectedUser);
    void unlikeComment(Comment selectedComment, User selectedUser);
}
