package com.example.jpa.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@Entity //JPA를 사용할 클래스를 명시하며, 데이터베이스의 테이블과 매핑하는 역할
@Table(name="board") //name 속성을 이용해 데이터베이스상의 실제 테이블 명칭을 지정해주지 않으면
                     //클래스 이름 그대로 테이블이 생성되기 때문에 테이블명을 명시적으로 작성하는거이 관례
public class BoardEntity {

    @Id //객체의 인스턴스를 구분하기 위한 유일한 키값 -> 테이블 상의 Primary Key와 같은 의미를 가진다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK컬럼이 auto increment 컬럼인 것을 EntityManager에게 알려주는것.
    @Column(name = "boardseq") //데이터베이스상에서 boardSeq 카멜표기법으로 되어있으면 인식을 하지 못하고 스네이크 표기법으로 바꾸어 컬럼을 새로 추가한다.
    private Long boardSeq; //PK컬럼의 데이터 형식은 정해져 있지 않으나 구분이 가능한 유일한 값을 가지고 있어야하고
                              //데드락같은 현상을 방지하기 위해 대부분 BigInteger 즉 java의 Long을 주로 사용합니다.
                              //-> MYSQL은 auto increment방식으로 ORACLE은 sequence방식을 사용한다.

    @Column //name 속성을 명시하지 않으면 Entity 클래스에 정의한 컬럼 변수의 이름으로 생성된다.
    private int writer;

    @Column //(length = 100) 실제 데이터가 가질수 있는 최대 길이를 관리하기 위해 length속성으로 길이를 명시할 수 있다. default=255  -> varchar(255)
            //이것은 문자열 형태인 데이터 속성에만 해당된다.
    private String title;

    @Column
    private String contents;

    @CreationTimestamp  //Insert시 자동으로 현재시간 등록해주는 어노테이션
//    @UpdateTimestamp  update시 자동으로 현재시간 등록해주는 어노테이션
    @Column(name = "createdate")
    private LocalDateTime createDate;

    public BoardEntity(Long boardSeq, int writer, String title, String contents, LocalDateTime createDate) {
        this.boardSeq = boardSeq;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createDate = createDate;
    }

//    service 단에서 아래와 같이 사용해서 계층별로 구분해서 사용해야한다.
//    public BoardDto toDto(BoardEntity boardEntity) {
//        return BoardDto.builder()
//                .boardSeq(boardEntity.getBoardSeq())
//                .writer(boardEntity.getWriter())
//                .title(boardEntity.getTitle())
//                .contents(boardEntity.getContents())
//                .createDate(boardEntity.getCreateDate())
//                .build();
//    }

}
