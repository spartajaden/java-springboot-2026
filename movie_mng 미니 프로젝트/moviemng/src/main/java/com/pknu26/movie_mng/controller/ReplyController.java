package com.pknu26.movie_mng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.movie_mng.entity.Board;
import com.pknu26.movie_mng.service.BoardService;
import com.pknu26.movie_mng.service.ReplyService;
import jakarta.validation.Valid;

@RequestMapping("/reply")
@Controller
public class ReplyController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    @PostMapping("/create/{bno}")
    public String createReply(Model model, @Valid ReplyController replyController, 
                              BindingResult bindingResult, @PathVariable("bno") Long bno) {
        Board board = this.boardService.getBoardOne(bno);

        if (bindingResult.hasErrors()){
            model.addAttribute("board", board);
            return "board_detail";
        } 
        
        this.replyService.setReply(board, replyController.getContent());
        return "redirect:/board/list";
    }

    private Object getContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }
}
