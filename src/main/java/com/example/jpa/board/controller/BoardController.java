package com.example.jpa.board.controller;

import com.example.jpa.board.entity.Board;
import com.example.jpa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor // 생성자 주입을 대신해주는 롬복 어노테이션, final 객체를 Contructor Injection 해줌.(Autowired 역할)
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "")
    public List<Board> findAllBoard() {
        return boardService.findAllBoard();
    }

    @GetMapping(value="/{boardSeq}")
    public Optional<Board> findBoardBySeq(@PathVariable("boardSeq") Long boardSeq) {
        return boardService.findBoardBySeq(boardSeq);
    }




}
