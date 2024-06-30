package com.example.demo.domain.comment;

import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;

public class CommentFixture {

    public static Comment comment(User user, Board board) {
        return new Comment("content", user, board);
    }
}
