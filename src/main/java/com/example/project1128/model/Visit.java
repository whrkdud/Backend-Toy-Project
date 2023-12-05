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
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer visitSeq;
    private String visitComment;
    private String visitwriter;
    LocalDateTime visitNow = LocalDateTime.now();
    private String visitWriteDate = visitNow.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
}
