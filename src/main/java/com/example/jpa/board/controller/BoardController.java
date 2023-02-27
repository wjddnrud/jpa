package com.example.jpa.board.controller;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import com.example.jpa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "")
    public ResponseEntity<Page<BoardEntity>> findBoardAll(Pageable pageable) {
        return boardService.findBoardAll(pageable);
    }

    @GetMapping(value="/{boardSeq}")
    public ResponseEntity<Optional<BoardEntity>> findBoardByBoardSeq(@PathVariable("boardSeq") Long boardSeq) {
        return boardService.findBoardBySeq(boardSeq);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<BoardEntity>> findBoardByTitle(@RequestParam String title, Pageable pageable) {
        return boardService.findByTitleContaining(title, pageable);
    }

    @DeleteMapping(value="/{boardSeq}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardSeq") Long boardSeq) {
        return boardService.deleteBoard(boardSeq);
    }

    @PostMapping(value="")
    public ResponseEntity<BoardDto> saveBoard(@RequestBody BoardDto boardDto) {
        return boardService.saveBoard(boardDto);
    }


//    @GetMapping(value="")
//    public
}
