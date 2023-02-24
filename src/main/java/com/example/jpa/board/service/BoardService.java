package com.example.jpa.board.service;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import com.example.jpa.board.repository.BoardRepository;
import com.example.jpa.common.Constants;
import com.example.jpa.common.exception.BoardException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Page<BoardDto>> findBoardAll(Pageable pageable) throws BoardException {
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);
        if(boardEntityList.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        Page<BoardDto> boardDtoList = BoardDto.builder().build().toDtoList(boardEntityList);
        return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<BoardDto> findBoardBySeq(Long boardSeq) throws BoardException {
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
        if(boardEntity.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK , "조회된 게시물이 없습니다.");
        }
        BoardDto boardDto = BoardDto.builder().build().toDto(boardEntity);
        return new ResponseEntity<>(boardDto, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Page<BoardDto>> findByTitleContaining(String title, Pageable pageable) throws BoardException {
        Page<BoardEntity> boardEntityList = boardRepository.findByTitleContaining(title, pageable);
        if(boardEntityList.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        Page<BoardDto> boardDtoList = BoardDto.builder().build().toDtoList(boardEntityList);
        return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<String> deleteBoard(Long boardSeq) throws BoardException {
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
        if(boardEntity.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "존재하지 않는 게시물입니다.");
        }
        boardRepository.deleteById(boardSeq);
        return new ResponseEntity<>("게시물이 삭제되었습니다.", HttpStatus.OK);
    }

    public ResponseEntity<BoardDto> insertBoard(BoardDto boardDto) throws BoardException{

        System.out.println("boardDto.getTitle : " + boardDto.getTitle());
        System.out.println("boardDto.getContents : " + boardDto.getContents());

        BoardEntity boardEntity = BoardEntity.builder().build().toEntity(boardDto);
        System.out.println("boardEntity.getTitle : " + boardEntity.getTitle());
        System.out.println("boardEntity.getContents : " + boardEntity.getContents());

        boardRepository.save(boardEntity);
        if(StringUtils.hasText(boardDto.getTitle())) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "제목 및 내용을 입력해주세요.");
        }
        if(StringUtils.hasText(boardDto.getContents())) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "제목 및 내용을 입력해주세요.");
        }
//        if(boardDto.getTitle() == null || boardDto.getTitle().equals("") || boardDto.getTitle().equals(" ")){
//
//        }
//        if(boardDto.getContents() == null || boardDto.getContents().equals("") || boardDto.getContents().equals(" ")){
//            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "제목 및 내용을 입력해주세요.");
//        }
        return new ResponseEntity<>(boardDto, HttpStatus.CREATED);
    }
}
