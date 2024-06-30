package com.example.demo.domain.comment;

import com.example.demo.domain.board.BoardFixture;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.repository.BoardRepository;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.user.UserFixture;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void findByIdAndBoardId() {
        // Given
        User user = UserFixture.user();
        userRepository.save(user);

        Board board = BoardFixture.board(user);
        boardRepository.save(board);

        Comment comment = CommentFixture.comment(user, board);
        commentRepository.save(comment);

        // When


        // Then
        assertEquals(comment, commentRepository.findByIdAndBoardId(comment.getId(), comment.getId()).get());
    }
}
