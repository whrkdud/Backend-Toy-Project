package com.example.project1128.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project1128.model.Member;
import com.example.project1128.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String login() {
        return "html/login";
    }

    @PostMapping("/login")
    public String loginPost(
        @RequestParam("memberId") String memberId,
        @RequestParam("memberPw") String memberPw,
        HttpSession session
    ) {
        Member member;
        member = memberRepository.findByMemberIdAndMemberPw(memberId, memberPw);
        session.setAttribute("member", member);
        int count = memberRepository.findByMemberPwAndMemberId(memberPw, memberId).size();
        if (count < 1){
            return "html/loginFail";
        }
        return "redirect:/main";
    }

    @GetMapping("/register")
    public String register() {
        return "html/register";
    }
    
    @PostMapping("/register")
    public String registerPost(
        @RequestParam("memberId") String memberId,
        @RequestParam("memberName") String memberName,
        @RequestParam("memberPw") String memberPw,
        HttpSession session
    ) {
        Member member = new Member();
        if(memberId == "" || memberName == "" || memberPw == "") {
            return "html/register";
        } else {
            member.setMemberId(memberId);
            member.setMemberName(memberName);
            member.setMemberPw(memberPw);
            session.setAttribute("member", member);
            memberRepository.save(member);
            return "html/registerSuccess";
        }
    }

}
