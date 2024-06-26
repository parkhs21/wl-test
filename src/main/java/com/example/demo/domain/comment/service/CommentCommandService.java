package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.user.entity.User;

public interface CommentCommandService {
    void createComment(Board selectedBoard, User writer, CommentCreateReq req);
}
