package com.example.demo.domain.comment.service.impl;

import com.example.demo.domain.comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentCommandServiceImpl implements CommentCommandService {
}
