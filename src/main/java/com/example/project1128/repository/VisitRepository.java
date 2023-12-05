package com.example.project1128.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1128.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    
} 
