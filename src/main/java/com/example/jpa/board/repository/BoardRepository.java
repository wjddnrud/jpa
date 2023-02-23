package com.example.jpa.board.repository;

import com.example.jpa.board.dto.BoardDto;
import com.example.jpa.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
//    JpaRepository안의 메서드와 변수들을 상속받아 이 안에서도 사용 가능해진다.
//    implements는 interface가 구현되어있어야하고 부모객체(interface)는 선언만 하며 정의(내용)은 자식(implements)에서 오버라이딩(재정의)해서 사용해야한다.
//    abstract 는 extends와 interface 혼합으로 extends 하되 몇개는 추상 메서드로 구현되어있다.

//    레파지토리는 구현체가 아니기 때문에 리턴값이 없고 service에서 구현하기 때문에 여기서는 jpa메서드에 맞는 디폴트 파라미터 타입만 맞춰주면된다.
//    대신 jpa를 통해 만져진 데이터를 dto에 담아서 리턴해주면된다.

    Page<BoardEntity> findAll(Pageable pageable);

    Optional<BoardEntity> findById(Long boardSeq);

    Page<BoardEntity> findByTitleContaining(String title, Pageable pageable);

    BoardEntity save(BoardEntity entity);

    void deleteById(Long boardSeq);






    //JpaRepository를 상속하여 인터페이스 생성, Jpa 인터페이스의 타입 파라미터(제네릭타입)는 적용될 데이터 타입(T)과 PK의 데이터 타입을 기입
    //JpaRepository를 들어가보면 내부 코드안에 ddl 명령어가 들어있다 -> dialect

}
