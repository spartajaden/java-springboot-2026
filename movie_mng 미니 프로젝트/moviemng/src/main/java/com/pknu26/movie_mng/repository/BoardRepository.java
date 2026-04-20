package com.pknu26.movie_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pknu26.movie_mng.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // INSERT, UPDATE, SELECT, DELETE 쿼리 수행
    // 필요한 기능이 있으면 아래 작성.
}
