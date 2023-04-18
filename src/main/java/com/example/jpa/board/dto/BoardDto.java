package com.example.jpa.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter

public class BoardDto {

    private Long boardSeq;

    private int writer;

    private String title;

    private String contents;

    private Date createDate;


//    @Builder
//    public BoardDto(Long boardSeq, int writer, String title, String contents, LocalDateTime createDate) {
//        this.boardSeq = boardSeq;
//        this.writer = writer;
//        this.title = title;
//        this.contents = contents;
//        this.createDate = createDate;
//    }
//
//
//    public BoardDto toDto(Optional<BoardEntity> oneBoard) {
//        return BoardDto.builder()
//                .boardSeq(oneBoard.get().getBoardSeq())
//                .writer(oneBoard.get().getWriter())
//                .title(oneBoard.get().getTitle())
//                .contents(oneBoard.get().getContents())
//                .createDate(oneBoard.get().getCreateDate())
//                .build();
//    }
//
//    public Page<BoardDto> toDtoList(Page<BoardEntity> boardList) {
//        return boardList.map(m -> BoardDto.builder()
//                .boardSeq(m.getBoardSeq())
//                .writer(m.getWriter())
//                .title(m.getTitle())
//                .contents(m.getContents())
//                .createDate(m.getCreateDate())
//                .build());
//    }
}
