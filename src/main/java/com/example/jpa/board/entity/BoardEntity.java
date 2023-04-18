package com.example.jpa.board.entity;

import com.example.jpa.member.entity.MemberEntity;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@Table(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long bdSeq;

    @Column(name = "bd_mmSeq")
    private int bdWriter;

    @Column
    private String bdTitle;

    @Column
    private String bdContents;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date bdCreateDate;





//    @ManyToOne
//    @JoinColumn(name = "bd_mmSeq")
//    private MemberEntity memberEntity;



//    =================================================================================================
    // 연관 맵핑을 처리하기 위해 memberEntity 변수를 선언하고
    // 게시물과 회원은 N:1관계
//    @ManyToOne // 다대일 관계 설정을 위한 @ManyToOne 어노테이션 추가
//    @JoinColumn(name = "mmseq") //외래키 맵핑을 위해 @JoinColumn 어노테이션 추가
//    @JoinTable(name = "board_member", joinColumns = @JoinColumn(name = "bdSeq"), inverseJoinColumns = @JoinColumn(name = "mmSeq"))
//    private MemberEntity memberEntity;


    //현재 클래스가 연관관계 주인
//    @ManyToOne
//    @JoinColumn(name = "bd_mmSeq")
//    private MemberEntity memberEntity;
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
