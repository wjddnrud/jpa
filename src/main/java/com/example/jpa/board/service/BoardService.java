package com.example.jpa.board.service;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import com.example.jpa.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public ResponseEntity<Page<BoardEntity>> findBoardAll(Pageable pageable) {
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);
//        Page<BoadBoardDto> boardDtoList = BoardDto.builder().build().toDtoList(boardEntityList);
        return new ResponseEntity<>(boardEntityList, HttpStatus.OK);
    }

    public ResponseEntity <Optional<BoardEntity>> findBoardBySeq(Long boardSeq) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
//        BoardDto boardDto = BoardDto.builder().build().toDto(boardEntity);
        return new ResponseEntity<>(boardEntity, HttpStatus.OK);
    }

    public ResponseEntity<Page<BoardEntity>> findByTitleContaining(String title, Pageable pageable) {
        Page<BoardEntity> boardEntityList = boardRepository.findByTitleContaining(title, pageable);
//        Page<BoardDto> boardDtoList = BoardDto.builder().build().toDtoList(boardEntityList);
        return new ResponseEntity<>(boardEntityList, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBoard(Long boardSeq) {
//        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
//        if(boardEntity.isEmpty()) {
//            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "존재하지 않는 게시물입니다.");
//        }
        boardRepository.deleteById(boardSeq);
        return new ResponseEntity<>("게시물이 삭제되었습니다.", HttpStatus.OK);
    }

    public ResponseEntity<BoardDto> saveBoard(BoardDto boardDto) {
        boardRepository.save(boardDto);
        return new ResponseEntity<>(boardDto, HttpStatus.CREATED);
    }
}

