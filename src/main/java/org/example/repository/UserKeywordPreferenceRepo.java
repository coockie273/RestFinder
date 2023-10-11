package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserKeywordPreferenceRepo extends JpaRepository<UserKeywordPreference, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM UserKeywordPreference WHERE user_id = :u_id AND keyword_id = :k_id")
    void deleteByIds(@Param("u_id") Long u_id, @Param("k_id") Long k_id);
}