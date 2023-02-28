package com.example.jpa.member.entity;

import com.example.jpa.board.entity.BoardEntity;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mmSeq")
    private Long mmSeq;

    @Column
    private String mmName;

    @Column
    private int mmGender;

    @CreationTimestamp
    @Column
    private LocalDateTime mmCreateDate;


    //양방향 연관관계 설정
//    @OneToMany(mappedBy = "member")
//    private List<BoardEntity> boardEntities = new ArrayList<>();


}
