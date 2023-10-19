package org.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    Keyword findByName(String name);
}