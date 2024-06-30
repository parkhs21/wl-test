package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.entity.User;

public class BoardMapper {
    public static Board toEntity(User writer, CreateBoard createBoard) {
        return new Board(createBoard.title(), createBoard.content(), writer);
    }
}
