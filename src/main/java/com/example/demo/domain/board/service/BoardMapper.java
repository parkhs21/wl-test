package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.dto.response.BoardGetRes;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserMapper;

public class BoardMapper {
    public static Board toBoard(User writer, BoardCreateReq req) {
        return Board.builder()
                .title(req.title())
                .content(req.content())
                .writer(writer)
                .build();
    }

    public static BoardGetRes toBoardGetRes(Board board) {
        return BoardGetRes.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(UserMapper.toUserGetRes(board.getWriter()))
                .likeCount(board.getLikeCount())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}
