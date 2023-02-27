package com.example.jpa.board.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MemberEntity {

    @Id
    @Column
    private Long mmSeq;

    @Column
    private String mmName;

    @Column
    private int mmGender;

    @Column
    private LocalDateTime mmCreateDate;



}
