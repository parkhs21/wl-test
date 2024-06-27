package com.example.demo.domain.board.service.impl;

import com.example.demo.domain.board.controller.BoardErrorStatus;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.repository.BoardRepository;
import com.example.demo.domain.board.service.BoardQueryService;
import com.example.demo.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardQueryServiceImpl implements BoardQueryService {

    private final BoardRepository boardRepository;

    @Override
    public Board getBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new GeneralException(BoardErrorStatus.BOARD_NOT_FOUND));
    }

    @Override
    public Page<Board> getBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
