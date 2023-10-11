package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KitchenRepo extends JpaRepository<Kitchen,Long> {
        Kitchen findByName(String name);
}