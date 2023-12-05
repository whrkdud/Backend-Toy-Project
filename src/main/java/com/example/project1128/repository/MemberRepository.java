// sql 문법쓰는거

package com.example.project1128.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1128.model.Member;

import java.util.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByMemberIdAndMemberPw(String memberId, String memberPw);
    List<Member> findByMemberPwAndMemberId(String memberPw, String memberId);
}
