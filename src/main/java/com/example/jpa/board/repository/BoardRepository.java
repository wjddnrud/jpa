package com.example.jpa.board.repository;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    Page<BoardEntity> findAll(Pageable pageable);

    Optional<BoardEntity> findById(Long boardSeq);

    Page<BoardEntity> findByTitleContaining(String title, Pageable pageable);

    void deleteById(Long boardSeq);

    BoardEntity save(BoardDto boardDto);

}
