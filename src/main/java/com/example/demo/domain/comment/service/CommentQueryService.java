package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.entity.Comment;

public interface CommentQueryService {
    Comment getComment(Long commentId);
}
