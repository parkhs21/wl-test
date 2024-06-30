package com.example.demo.domain.board;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.entity.User;

public class BoardFixture {

    public static Board board(User user) {
        return new Board("title", "content", user);
    }
}
