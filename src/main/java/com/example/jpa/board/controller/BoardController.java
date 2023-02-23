package com.example.jpa.board.controller;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import com.example.jpa.board.service.BoardService;
import com.example.jpa.common.exception.BoardException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor // 생성자 주입을 대신해주는 롬복 어노테이션, final 객체를 Contructor Injection 해줌.(Autowired 역할)
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
    public ResponseEntity<Page<BoardEntity>> findBoardByTitle(@RequestParam String title, Pageable pageable)throws BoardException {
        return boardService.findByTitleContaining(title, pageable);
    }

    @PostMapping(value = "")
    public ResponseEntity<BoardEntity> saveBoard(@RequestBody BoardEntity entity) throws BoardException {
        return boardService.saveBoard(entity);
    }

    @DeleteMapping(value="/{boardSeq}")
    public ResponseEntity<BoardEntity> deleteBoard(@PathVariable("boardSeq") Long boardSeq) throws BoardException {
        return boardService.deleteBoard(boardSeq);
    }
}
