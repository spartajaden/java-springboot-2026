package com.pknu26.studygroup.service;

import java.util.List;

import com.pknu26.studygroup.dto.Board;
import com.pknu26.studygroup.validation.BoardForm;

// 서비스를 구현할때 반드시 아래의 매서드를 전부 구현할 것
public interface BoardService {
    // CRUD = Create, Read(Select), Update, Delete
    void createBoard(BoardForm boardForm);

    void updateBoard(BoardForm boardForm);
    
    void deleteBoard(Long boardId);

    List<Board> readBoardList();

    Board readBoardById(Long boardId);
}
