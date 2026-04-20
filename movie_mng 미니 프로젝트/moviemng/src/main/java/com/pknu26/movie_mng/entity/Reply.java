package com.pknu26.movie_mng.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.*;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.*;
import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

// 게시글에 속한 댓글 테이블
@Entity
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_seq")
    @SequenceGenerator(name="reply_seq", sequenceName="reply_seq", allocationSize = 1) // 1씩 증가
    private Long rno;   // Reply PK 컬럼

    @Column(length = 1000)
    private String content;

    @CreatedDate    // 생성일자
    @Column(updatable = false)  // 최초 작성시 생성 후 수정 X
    private LocalDateTime createDate;   // 게시글 작성일

    @LastModifiedBy // 수정될 떄 마다 날짜 변경
    private LocalDateTime modifyDate;   // 게시글 수정일

    // ERD N:1 관계정립
    @ManyToOne
    private Board board;
}