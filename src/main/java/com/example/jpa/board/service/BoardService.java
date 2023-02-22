package com.example.jpa.board.service;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.repository.BoardRepository;
import com.example.jpa.board.entity.BoardEntity;
import com.example.jpa.common.Constants;
import com.example.jpa.common.exception.BoardException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public ResponseEntity<Page<BoardEntity>> findBoardAll(Pageable pageable) throws BoardException {
        Page<BoardEntity> list = boardRepository.findAll(pageable);
        if(list.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    [처음에 생각했던 Map을 활용한 return 만들기]
//    public Map<String, Object> findBoardAll(Pageable pageable) throws BoardException {
//        Map<String, Object> response = new HashMap<>();
//        List<BoardEntity> list = boardRepository.findAll();
//        if(list.isEmpty()) {
//            response.put("body", "조회된 게시물이 없습니다.");
//        } else {
//            response.put("body", list);
//            response.put("HttpStatus", HttpStatus.OK);
//        }
//        return response;
//    }

    public ResponseEntity<Optional<BoardEntity>> findBoardBySeq(Long boardSeq) throws BoardException {
        Optional<BoardEntity> One = boardRepository.findById(boardSeq);
        if(One.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        return new ResponseEntity<>(One, HttpStatus.OK);
    }

    public ResponseEntity<Page<BoardEntity>> findByTitleContaining(String title, Pageable pageable) throws BoardException {

        Page<BoardEntity> list = boardRepository.findByTitleContaining(title, pageable);
        if(list.isEmpty()) {
            throw new BoardException(Constants.ExceptionClass.BOARD, HttpStatus.OK, "조회된 게시물이 없습니다.");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<BoardEntity> saveBoard(BoardEntity entity) throws BoardException {
        boardRepository.save(entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

//    어차피 save 하나로 insert와 update기능을 둘다 할 수 있기 때문에 굳이 나눠줄 필요가 있을지...?
//    하나에 담아서 키값 체크하기
//    레이어를 나눠 service에서 로직을 짜줄려면 세분화해서 쓰는게 맞는거 같기도하고...?
//    아~ 근데 save() 는 파라미터로 받을수 있는게 entity밖에 없어서 키값으로 구분해줄거면 하나의 service로직에서 짜야하나봄;;;

    public ResponseEntity<Optional<BoardEntity>> deleteBoard(Long boardSeq) throws BoardException {
        Optional<BoardEntity> One = boardRepository.findById(boardSeq);
        boardRepository.deleteById(boardSeq);
        return new ResponseEntity<>(One, HttpStatus.OK);
    }

}
