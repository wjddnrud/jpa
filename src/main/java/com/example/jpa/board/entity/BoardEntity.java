package com.example.jpa.board.entity;

import com.example.jpa.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Entity
@Table(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardseq")
    private Long boardSeq;

    @Column
    private int writer;

    @Column
    private String title;

    @Column
    private String contents;

    @CreationTimestamp
    @Column(name = "createdate")
    private LocalDateTime createDate;


    public BoardEntity toEntity (BoardDto boardDto) {
        return BoardEntity.builder()
                .boardSeq(boardDto.getBoardSeq())
                .writer(boardDto.getWriter())
                .title(boardDto.getTitle())
                .contents(boardDto.getContents())
                .createDate(boardDto.getCreateDate())
                .build();
    }

}
