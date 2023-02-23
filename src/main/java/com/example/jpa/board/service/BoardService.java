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

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public ResponseEntity<Page<BoardDto>> findBoardAll(Pageable pageable) throws BoardException {
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);
        Page<BoardDto> boardDtoList = BoardDto.builder().build().toDtoList(boardEntityList);
        if(boardDtoList.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
    }

    public ResponseEntity<BoardDto> findBoardBySeq(Long boardSeq) throws BoardException {
        Optional<BoardEntity> oneBoard = boardRepository.findById(boardSeq);
        if(oneBoard.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK , "조회된 게시물이 없습니다.");
        }
        BoardDto boardDto = BoardDto.builder().build().toEntity(oneBoard);
        return new ResponseEntity<>(boardDto, HttpStatus.OK);
    }

    public ResponseEntity<Page<BoardEntity>> findByTitleContaining(String title, Pageable pageable) throws BoardException {
        Page<BoardEntity> boardList = boardRepository.findByTitleContaining(title, pageable);
        if(boardList.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    public ResponseEntity<BoardEntity> saveBoard(BoardEntity entity) {
        boardRepository.save(entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

//    어차피 save 하나로 insert와 update기능을 둘다 할 수 있기 때문에 굳이 나눠줄 필요가 있을지...?
//    하나에 담아서 키값 체크하기
//    레이어를 나눠 service에서 로직을 짜줄려면 세분화해서 쓰는게 맞는거 같기도하고...?
//    아~ 근데 save() 는 파라미터로 받을수 있는게 entity밖에 없어서 키값으로 구분해줄거면 하나의 service로직에서 짜야하나봄;;;

    public ResponseEntity<BoardEntity> deleteBoard(Long boardSeq) {

        BoardEntity boardEntity = BoardEntity.builder()
                                             .boardSeq(boardSeq)
                                             .build();
        System.out.println("entity.boardSeq : " + boardEntity.getBoardSeq());
        boardRepository.deleteById(boardEntity.getBoardSeq());
        return new ResponseEntity<>(boardEntity, HttpStatus.OK);
    }
}
