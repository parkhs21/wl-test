package com.example.demo.domain.board.service.impl;

import com.example.demo.domain.board.dto.request.BoardCreateReq;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.repository.BoardRepository;
import com.example.demo.domain.board.service.BoardCommandService;
import com.example.demo.domain.board.service.BoardMapper;
import com.example.demo.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardCommandServiceImpl implements BoardCommandService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void createBoard(User writer, BoardCreateReq req) {
        Board newBoard = BoardMapper.toBoard(writer, req);
        boardRepository.save(newBoard);
    }
}
