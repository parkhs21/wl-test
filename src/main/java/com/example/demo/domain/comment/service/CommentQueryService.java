package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.exception.NotFoundCommentException;
import com.example.demo.domain.comment.repository.CommentRepository;
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
                .orElseThrow(NotFoundCommentException::new);
    }
}
