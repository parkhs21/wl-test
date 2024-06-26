package com.example.demo.domain.board.service;

import com.example.demo.domain.board.entity.Board;

public interface BoardQueryService {
    Board getBoard(Long boardId);
}
