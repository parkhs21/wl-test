package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.user.entity.User;

public interface BoardCommandService {
    void createBoard(User writer, BoardCreateReq req);
}
