package com.example.demo.domain.board.service;

import com.example.demo.domain.board.dto.request.CreateBoard;
import com.example.demo.domain.board.dto.response.GetBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.service.CommentMapper;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.service.UserMapper;
import org.springframework.data.domain.Page;

public class BoardMapper {
    public static Board toEntity(User writer, CreateBoard createBoard) {
        return new Board(createBoard.title(), createBoard.content(), writer);
    }

    public static GetBoard toBoardGetRes(Board board) {
        return new GetBoard(board);
    }

    public static Page<GetBoard> toBoardsGetRes(Page<Board> boards) {
        return boards.map(BoardMapper::toBoardGetRes);
    }
}
