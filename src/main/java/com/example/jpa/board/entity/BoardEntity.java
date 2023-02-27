package com.example.jpa.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinTable(name="BOARD_MEMBER", joinColumns = @JoinColumn(name="writer"), inverseJoinColumns = @JoinColumn(name="mmSeq"))
    private BoardEntity boardEntity;


//    @Builder
//    public BoardEntity(Long boardSeq, int writer, String title, String contents, LocalDateTime createDate) {
//        this.boardSeq = boardSeq;
//        this.writer = writer;
//        this.title = title;
//        this.contents = contents;
//        this.createDate = createDate;
//    }
//
//    public BoardEntity toEntity(BoardDto boardDto) {
//        return BoardEntity.builder()
//                .boardSeq(boardDto.getBoardSeq())
//                .writer(boardDto.getWriter())
//                .title(boardDto.getTitle())
//                .contents(boardDto.getContents())
//                .createDate(boardDto.getCreateDate())
//                .build();
//    }
//
//    public Page<BoardEntity> toEntityList(Page<BoardDto> boardDtoList) {
//        return boardDtoList.map(m -> BoardEntity.builder()
//                .boardSeq(m.getBoardSeq())
//                .writer(m.getWriter())
//                .title(m.getTitle())
//                .contents(m.getContents())
//                .createDate(m.getCreateDate())
//                .build());
//    }

}
