package com.example.demo.domain.board.service;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.exception.NotFoundBoardException;
import com.example.demo.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardQueryService {

    private final BoardRepository boardRepository;

    public Board getBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(NotFoundBoardException::new);
    }
}
