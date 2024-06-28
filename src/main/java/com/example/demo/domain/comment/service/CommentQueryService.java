package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.entity.CommentLike;

public interface CommentQueryService {
    Comment getComment(long boardId, long commentId);
}
