package com.example.project1128.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project1128.model.Board;
import com.example.project1128.repository.BoardRepository;
import com.example.project1128.repository.VisitRepository;

@Controller
public class DBController {
    @Autowired
    BoardRepository boardRepository;
    VisitRepository visitRepository;

    @PostMapping("/postdelete")
    public String boardDelete(
        @RequestParam("boardSeq") Integer boardSeq
    ){
        Board deleteData = new Board();
        deleteData.setBoardSeq(boardSeq);
        boardRepository.delete(deleteData);
        return "redirect:/main";
    }

    // @PostMapping("/visitdelete")
    // public String visitDelete(
    //     @RequestParam("visitSeq") Integer visitSeq
    // ) {
    //     Visit visitDeleteData = new Visit();
    //     visitDeleteData.setVisitSeq(visitSeq);
    //     visitRepository.delete(visitDeleteData);
    //     return "redirect:/main";
    // } // 방명록 삭제를 구현하려했는데 값을 자꾸 못받아와서 실패했습니다...ㅠ
}
