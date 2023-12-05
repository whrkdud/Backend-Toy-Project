package com.example.project1128.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1128.model.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {
    PostComment findByBoardSeq(Integer boardSeq);
}
