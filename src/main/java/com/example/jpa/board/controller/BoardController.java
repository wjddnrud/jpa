package com.example.jpa.board.controller;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.service.BoardService;
import com.example.jpa.common.exception.BoardException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "")
    public ResponseEntity<Page<BoardDto>> findBoardAll(Pageable pageable) throws BoardException {
        return boardService.findBoardAll(pageable);
    }

    @GetMapping(value="/{boardSeq}")
    public ResponseEntity<BoardDto> findBoardByBoardSeq(@PathVariable("boardSeq") Long boardSeq) throws BoardException{
        return boardService.findBoardBySeq(boardSeq);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<BoardDto>> findBoardByTitle(@RequestParam String title, Pageable pageable)throws BoardException {
        return boardService.findByTitleContaining(title, pageable);
    }

    @DeleteMapping(value="/{boardSeq}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardSeq") Long boardSeq) throws BoardException {
        return boardService.deleteBoard(boardSeq);
    }

    @PostMapping(value="")
    public ResponseEntity<BoardDto> insertBoard(@RequestBody BoardDto boardDto) throws BoardException {
        return boardService.insertBoard(boardDto);
    }
}
