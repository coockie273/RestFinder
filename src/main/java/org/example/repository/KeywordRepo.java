package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    Keyword findByName(String name);
}