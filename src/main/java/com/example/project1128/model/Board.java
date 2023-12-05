package com.example.project1128.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardSeq;
    private String boardTitle;
    private String boardWriter;
    LocalDateTime boardNow = LocalDateTime.now();
    private String boardWriteDate = boardNow.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    private String boardContent;
    @ColumnDefault("0")
    private int boardCnt;
}
