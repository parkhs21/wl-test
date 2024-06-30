package com.example.demo.domain.board;

import com.example.demo.domain.board.dto.request.UpdateBoard;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.user.UserFixture;
import com.example.demo.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    @DisplayName("Update DTO 로 update 되는 지 확인")
    void update() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);
        UpdateBoard updateBoard = new UpdateBoard("updateTitle", "updateContent");

        // when
        board.update(updateBoard);

        // then
        assertEquals(updateBoard.title(), board.getTitle());
        assertEquals(updateBoard.content(), board.getContent());
    }

    @Test
    @DisplayName("like 되는 지 확인")
    void like() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);

        // when
        board.like(user);

        // then
        assertEquals(1, board.getLikes().size());
    }

    @Test
    @DisplayName("like 취소 되는 지 확인")
    void like_cancled() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);

        // when
        board.like(user);
        board.like(user);

        // then
        assertEquals(0, board.getLikes().size());
    }

    @Test
    @DisplayName("like 여러개 생기는 지 확인")
    void like_multiple() {
        // given
        User user = UserFixture.user();
        User otherUser = UserFixture.user("otherEmail");
        Board board = BoardFixture.board(user);

        // when
        board.like(user);
        board.like(otherUser);

        // then
        assertEquals(2, board.getLikes().size());
    }
}
