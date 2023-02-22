package com.example.jpa.board.dto;

import com.example.jpa.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class BoardDto {

    private Long boardSeq;

    private int writer;

    private String title;

    private String contents;

    private LocalDateTime createDate;

    @Builder
    public void BoardDto(int writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }

//    빌더패턴 잘 활용하기
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .writer(writer)
                .title(title)
                .contents(contents)
                .build();
    }

}
