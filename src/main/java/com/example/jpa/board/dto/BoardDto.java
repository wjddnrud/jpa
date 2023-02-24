package com.example.jpa.board.dto;

import com.example.jpa.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Builder

public class BoardDto {

    private Long boardSeq;

    private int writer;

    private String title;

    private String contents;

    private LocalDateTime createDate;

    public BoardDto toDto(Optional<BoardEntity> oneBoard) {
        return BoardDto.builder()
                       .boardSeq(oneBoard.get().getBoardSeq())
                       .writer(oneBoard.get().getWriter())
                       .title(oneBoard.get().getTitle())
                       .contents(oneBoard.get().getContents())
                       .createDate(oneBoard.get().getCreateDate())
                       .build();
    }

    public Page<BoardDto> toDtoList(Page<BoardEntity> boardList) {
        return boardList.map(m -> BoardDto.builder()
                .boardSeq(m.getBoardSeq())
                .writer(m.getWriter())
                .title(m.getTitle())
                .contents(m.getContents())
                .createDate(m.getCreateDate())
                .build());
    }
}
