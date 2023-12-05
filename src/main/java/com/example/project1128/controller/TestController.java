package com.example.project1128.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project1128.model.Board;
import com.example.project1128.model.PostComment;
import com.example.project1128.model.Visit;
import com.example.project1128.repository.BoardRepository;
import com.example.project1128.repository.PostCommentRepository;
import com.example.project1128.repository.VisitRepository;

// import jakarta.servlet.http.HttpServletRequest;



@Controller
public class TestController {
    @Autowired
    VisitRepository visitRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostCommentRepository postCommentRepository;

    @GetMapping("/register/success")
    public String registerSuccess() {
        return "html/registerSuccess";
    }

    @GetMapping("/main")
    public String main(
        Model model,
        @RequestParam(defaultValue = "1") int page
    ) {
        List<Visit> data = visitRepository.findAll(Sort.by(Sort.Direction.DESC, "visitSeq"));
        model.addAttribute("visit", data);
        
        List<Board> boardData = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardSeq"));
        model.addAttribute("board", boardData);
        
        int startPage = (page-1)/10 *10 +1;
        int endPage = startPage + 9;
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);
        
        return "html/main";
    }

    @PostMapping("/main")
    public String mainPost(@RequestParam("comment") String comment,
                           @RequestParam("memberName") String memberName){
        // System.out.println(comment);
        // System.out.println(memberName);
        // System.out.println("첫번째");
        Visit visit = new Visit();
        visit.setVisitComment(comment);
        visit.setVisitwriter(memberName);
        // System.out.println(visit);
        // System.out.println("두번째");
        visitRepository.save(visit);
        return "redirect:/main";
    }

    @GetMapping("/posting")
    public String posting() {
        return "html/posting";
    }

    @PostMapping("/posting")
    public String postingPost(
        @RequestParam("boardTitle") String boardTitle,
        @RequestParam("boardContent") String boardContent,
        @RequestParam("memberName") String memberName
    ) {
        Board board = new Board();
        board.setBoardTitle(boardTitle);
        board.setBoardWriter(memberName);
        board.setBoardContent(boardContent);
        boardRepository.save(board);
        return "redirect:/main";
    }

    @GetMapping("/post")
    public String post(
        @RequestParam("boardSeq") Integer boardSeq,
        Model model
        // HttpServletRequest request
        ) {
        List<PostComment> postCommentData = postCommentRepository.findAll(Sort.by(Sort.Direction.DESC, "postCommentSeq"));
        model.addAttribute("postComment", postCommentData);
        Board board = boardRepository.findByBoardSeq(boardSeq);
        model.addAttribute("board", board);

        // String boardSeq = request.getParameter("boardSeq");
        // String searchCount = boardDao.select(boardSeq).get(0).get("board_cnt").toString();
        // searchCount = Integer.toString(Integer.parseInt(searchCount) + 1);
        // boardDao.updateBoardCnt(boardSeq,searchCount);
        // jdbc로 조회수를 구현하려고 하였으나 제 역량이 부족해서... 성공하지 못했습니다ㅠ...

        return "html/post";
    }

    @PostMapping("/post")
    public String postPost(
        @RequestParam("postCommentComment") String postCommentComment,
        @RequestParam("memberName") String memberName,
        @RequestParam("boardSeq") Integer boardSeq
    ) {
        PostComment postComment = new PostComment();
        postComment.setPostCommentComment(postCommentComment);
        postComment.setPostCommentWriter(memberName);
        postComment.setBoardSeq(boardSeq);
        postCommentRepository.save(postComment);
        return String.format("redirect:/post?boardSeq=%s", boardSeq);
    }

    @GetMapping("/update")
    public String update(
    ) {
        return "html/update";
    }

    @PostMapping("/update")
    public String updatePost(
        @RequestParam("boardSeq") int boardSeq,
        Model model
    ) {
        Board board = boardRepository.findByBoardSeq(boardSeq);
        model.addAttribute("board", board);
        return "html/update";
    }
    
    @PostMapping("/postupdate")
    public String updatePost(
        @RequestParam("boardTitle") String boardTitle,
        @RequestParam("boardContent") String boardContent,
        @RequestParam("memberName") String memberName,
        @RequestParam("boardSeq") int boardSeq
    ) {
        Board board = new Board();
        board.setBoardTitle(boardTitle);
        board.setBoardWriter(memberName);
        board.setBoardContent(boardContent);
        board.setBoardSeq(boardSeq);
        boardRepository.save(board);
        return "redirect:/main";
    }
}
