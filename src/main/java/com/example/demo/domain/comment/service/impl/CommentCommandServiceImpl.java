package com.example.demo.domain.comment.service.impl;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.controller.CommentErrorStatus;
import com.example.demo.domain.comment.dto.request.CommentCreateReq;
import com.example.demo.domain.comment.dto.request.CommentUpdateReq;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.comment.service.CommentCommandService;
import com.example.demo.domain.comment.service.CommentMapper;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentCommandServiceImpl implements CommentCommandService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public void createComment(Board selectedBoard, User writer, CommentCreateReq req) {
        Comment newComment = CommentMapper.toComment(selectedBoard, writer, req);
        selectedBoard.addComment(newComment);
        commentRepository.save(newComment);
    }

    @Override
    @Transactional
    public void updateComment(Comment selectedComment, Long writerId, CommentUpdateReq req) {
        if (!selectedComment.getWriter().getId().equals(writerId))
            throw new GeneralException(CommentErrorStatus.COMMENT_UNAUTHORIZED);

        selectedComment.update(req.content());
        commentRepository.save(selectedComment);
    }
}
