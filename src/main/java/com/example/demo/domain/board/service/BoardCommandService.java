package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.dto.request.BoardUpdateReq;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.entity.User;

public interface BoardCommandService {
    void createBoard(User writer, BoardCreateReq req);
    void updateBoard(Board selectedBoard, Long userId, BoardUpdateReq req);
    void deleteBoard(Board selectedBoard, Long userId);
}
