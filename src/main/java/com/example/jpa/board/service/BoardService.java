package com.example.jpa.board.service;

import com.example.jpa.board.repository.BoardRepository;
import com.example.jpa.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> findBoardBySeq(Long boardSeq) {
        System.out.println(boardSeq);
        return boardRepository.findById(boardSeq);
    }
}
