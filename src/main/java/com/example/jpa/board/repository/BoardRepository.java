package com.example.jpa.board.repository;

import com.example.jpa.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    Page<BoardEntity> findAll(Pageable pageable);

    Optional<BoardEntity> findById(Long boardSeq);

    Page<BoardEntity> findByTitleContaining(String title, Pageable pageable);

    BoardEntity save(BoardEntity entity);

    void deleteById(Long boardSeq);





    //JpaRepository를 상속하여 인터페이스 생성, Jpa 인터페이스의 타입 파라미터(제네릭타입)는 적용될 데이터 타입(T)과 PK의 데이터 타입을 기입
    //JpaRepository를 들어가보면 내부 코드안에 ddl 명령어가 들어있다 -> dialect

}
