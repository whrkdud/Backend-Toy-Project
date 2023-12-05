package com.example.project1128.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1128.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findByBoardSeq(Integer boardSeq);
}