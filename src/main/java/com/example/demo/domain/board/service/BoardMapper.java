package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.entity.User;

public class BoardMapper {
    public static Board toBoard(User writer, BoardCreateReq req) {
        return Board.builder()
                .title(req.title())
                .content(req.content())
                .writer(writer)
                .build();
    }
}
