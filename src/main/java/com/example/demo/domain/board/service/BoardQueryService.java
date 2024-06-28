package com.example.demo.domain.board.service;

import com.example.demo.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryService {
    Board getBoard(Long boardId);
    Page<Board> getBoards(Pageable pageable);
}
