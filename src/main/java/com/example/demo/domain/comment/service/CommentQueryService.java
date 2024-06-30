package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.controller.CommentErrorStatus;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentQueryService {

    private final CommentRepository commentRepository;

    public Comment getComment(long boardId, long commentId) {
        return commentRepository.findByIdAndBoardId(commentId, boardId)
                .orElseThrow(() -> new GeneralException(CommentErrorStatus.COMMENT_NOT_FOUND));
    }
}
