package com.example.jpa.board.repository;

import com.example.jpa.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAll();

    Optional<Board> findById(Long boardSeq);


    //JpaRepository를 상속하여 인터페이스 생성, Jpa 인터페이스의 타입 파라미터(제네릭타입)는 적용될 데이터 타입(T)과 PK의 데이터 타입을 기입
    //JpaRepository를 들어가보면 내부 코드안에 ddl 명령어가 들어있다 -> dialect

}
