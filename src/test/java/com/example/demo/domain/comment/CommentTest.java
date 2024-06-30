package com.example.demo.domain.comment;

import com.example.demo.domain.board.BoardFixture;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.comment.CommentFixture;
import com.example.demo.domain.comment.dto.request.UpdateComment;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.UserFixture;
import com.example.demo.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentTest {

    @Test
    @DisplayName("Update DTO 로 update 되는 지 확인")
    void update() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);
        Comment comment = CommentFixture.comment(user, board);
        UpdateComment updateComment = new UpdateComment("updateContent");

        // when
        comment.update(updateComment);

        // then
        assertEquals(updateComment.content(), comment.getContent());
    }

    @Test
    @DisplayName("like 되는 지 확인")
    void like() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);
        Comment comment = CommentFixture.comment(user, board);

        // when
        comment.like(user);

        // then
        assertEquals(1, comment.getLikes().size());
    }

    @Test
    @DisplayName("like 취소 되는 지 확인")
    void like_cancled() {
        // given
        User user = UserFixture.user();
        Board board = BoardFixture.board(user);
        Comment comment = CommentFixture.comment(user, board);

        // when
        comment.like(user);
        comment.like(user);

        // then
        assertEquals(0, comment.getLikes().size());
    }

    @Test
    @DisplayName("like 여러개 생기는 지 확인")
    void like_multiple() {
        // given
        User user = UserFixture.user();
        User otherUser = UserFixture.user("otherEmail");
        Board board = BoardFixture.board(user);
        Comment comment = CommentFixture.comment(user, board);

        // when
        comment.like(user);
        comment.like(otherUser);

        // then
        assertEquals(2, comment.getLikes().size());
    }
}
