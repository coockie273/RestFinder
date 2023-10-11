package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestarauntRepo extends JpaRepository<Restaraunt,Long> {
    Restaraunt findByName(String name);
}