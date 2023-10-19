package org.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRestarauntRepo extends JpaRepository<UserRestaraunt, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM UserRestaraunt WHERE user_id = :u_id AND restaraunt_id = :r_id")
    void deleteByIds(@Param("u_id") Long u_id, @Param("r_id") Long r_id);
}