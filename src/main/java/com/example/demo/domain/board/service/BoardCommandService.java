package com.example.demo.domain.board.service;

import com.example.demo.domain.board.controller.BoardErrorStatus;
import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.dto.request.UpdateBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.repository.BoardRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardCommandService {

    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(User user, CreateBoard createBoard) {
        Board board = BoardMapper.toBoard(user, createBoard);
        boardRepository.save(board);
    }

    @Transactional
    public void updateBoard(Board board, Long userId, UpdateBoard updateBoard) {
        if (!board.getWriter().getId().equals(userId))
            throw new GeneralException(BoardErrorStatus.BOARD_UNAUTHORIZED);

        board.update(updateBoard);
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Board board, Long userId) {
        if (!board.getWriter().getId().equals(userId))
            throw new GeneralException(BoardErrorStatus.BOARD_UNAUTHORIZED);

        boardRepository.delete(board);
    }

    @Transactional
    public void likeBoard(Board board, User user) {
        if (board.getLikes().contains(user))
            throw new GeneralException(BoardErrorStatus.BOARD_LIKE_CONFLICT);

        board.like(user);
        boardRepository.save(board);
    }

    @Transactional
    public void unlikeBoard(Board board, User user) {
        if (!board.getLikes().contains(user))
            throw new GeneralException(BoardErrorStatus.BOARD_LIKE_NOT_FOUND);

        board.unlike(user);
        boardRepository.save(board);
    }
}
