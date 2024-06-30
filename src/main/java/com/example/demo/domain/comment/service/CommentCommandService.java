package com.example.demo.domain.comment.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.dto.request.CreateComment;
import com.example.demo.domain.comment.dto.request.UpdateComment;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.exception.UnauthorizedUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentCommandService {

    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(Board board, User user, CreateComment createComment) {
        Comment comment = CommentMapper.toEntity(board, user, createComment);
        board.addComment(comment);
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Comment comment, Long writerId, UpdateComment updateComment) {
        if (!comment.getWriter().getId().equals(writerId))
            throw new UnauthorizedUserException();

        comment.update(updateComment);
        commentRepository.save(comment);
    }

    public void deleteComment(Comment comment, Long userId) {
        if (!comment.getWriter().getId().equals(userId))
            throw new UnauthorizedUserException();

        commentRepository.delete(comment);
    }

    @Transactional
    public void likeComment(Comment comment, User user) {
        comment.like(user);
        commentRepository.save(comment);
    }
}
