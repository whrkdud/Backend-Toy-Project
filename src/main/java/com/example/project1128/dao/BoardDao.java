// jdbc로 조회수를 구현하려고 하였으나 제 역량이 부족해서... 성공하지 못했습니다...ㅠ

package com.example.project1128.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class BoardDao {
    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> select(String boardSeq) {
        String sqlStmt = String.format("select board_seq, board_write_date, board_cnt, board_now, board_title, board_writer, board_content from board where board_seq = %s", boardSeq);
        return jt.queryForList(sqlStmt);
    }

    public void updateBoardCnt(String boardSeq, String boardCnt){
        String sqlStmt = String.format("update board set board_cnt = '%s' where board_seq = '%s'", boardCnt, boardSeq);
        jt.execute(sqlStmt);
    }

}