package org.example.repository;

import org.example.abstraction.service.RestarauntService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RestarauntRepo extends JpaRepository<Restaraunt,Long> {
    Restaraunt findByName(String name);

    @Query("SELECT r_name, x, y FROM RestarauntFilter " +
            "WHERE x > :conditionX1 AND x < :conditionX2 AND y > :conditionY1 AND y < :conditionY2 " +
            "GROUP BY r_id")
    List<Object> getRestarauntsForLocation(@Param("conditionX1") String conditionX1,
                                               @Param("conditionX2") String conditionX2,
                                               @Param("conditionY1") String conditionY1,
                                               @Param("conditionY2") String conditionY2);

    @Query("SELECT r_name, x, y FROM RestarauntFilter " +
            "WHERE k_name = :conditionKeyword " +
            "GROUP BY r_id")
    List<Object> getRestarauntsForKeyword(@Param("conditionKeyword") String conditionKeyword);

    @Query("SELECT r_name, x, y FROM RestarauntFilter " +
            "WHERE kt_name = :conditionKitchen " +
            "GROUP BY r_id")
    List<Object> getRestarauntsForKitchen(@Param("conditionKitchen") String conditionKitchen);








}