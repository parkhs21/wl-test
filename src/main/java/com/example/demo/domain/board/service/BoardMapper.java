package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.dto.response.GetBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.service.CommentMapper;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserMapper;
import org.springframework.data.domain.Page;

public class BoardMapper {
    public static Board toBoard(User writer, CreateBoard req) {
        return Board.builder()
                .title(req.title())
                .content(req.content())
                .writer(writer)
                .build();
    }

    public static GetBoard toBoardGetRes(Board board) {
        return GetBoard.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(UserMapper.toUserGetRes(board.getWriter()))
                .likeCount(board.getLikeCount())
                .comments(CommentMapper.toCommentGetResList(board.getComments()))
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    public static Page<GetBoard> toBoardsGetRes(Page<Board> boards) {
        return boards.map(BoardMapper::toBoardGetRes);
    }
}
