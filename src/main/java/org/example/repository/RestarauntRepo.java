package org.example.repository;

import org.example.abstraction.service.RestarauntService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RestarauntRepo extends JpaRepository<Restaraunt,Long> {
    Restaraunt findByName(String name);

    @Query("SELECT r.id, r.name, r.coordinate_x, r.coordinate_y " +
            "FROM Restaraunt r " +
            "LEFT JOIN RestarauntKeyword rk " +
            "ON r.id = rk.restaraunt_id " +
            "LEFT JOIN Keyword k " +
            "ON k.id = rk.keyword_id " +
            "LEFT JOIN RestarauntKitchen rkt " +
            "ON r.id = rkt.restaraunt_id " +
            "LEFT JOIN Kitchen kt " +
            "ON kt.id = rkt.kitchen_id " +
            // ":criteria" +
            "GROUP BY r.id ")
    List<RestarauntService.RestarauntDto> getRestaraunts(@Param("critria") String criteria);
}