package com.example.project1128.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postCommentSeq;
    private String postCommentComment;
    private String postCommentWriter;
    LocalDateTime postCommentNow = LocalDateTime.now();
    private String postCommentWriteDate = postCommentNow.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    private Integer boardSeq;
}
