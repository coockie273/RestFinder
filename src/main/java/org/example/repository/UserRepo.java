package org.example.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.abstraction.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
    User signIn(@Param("login") String login, @Param("password") String password);


    @Query("SELECT k.name " +
            "FROM User u " +
            "INNER JOIN UserKeywordPreference up " +
            "ON u.id = up.user_id " +
            "INNER JOIN Keyword k " +
            "ON k.id = up.keyword_id " +
            "WHERE u.id = :id")
    List<String> showKeywordPreferences(@Param("id") Long id);

    @Query("SELECT k.name " +
            "FROM User u " + // Пробел после 'u'
            "INNER JOIN UserKitchenPreference up " +
            "ON u.id = up.user_id " +
            "INNER JOIN Kitchen k " +
            "ON k.id = up.kitchen_id " +
            "WHERE u.id = :id")
    List<String> showKitchenPreferences(@Param("id") Long id);

    @Query("SELECT r.name " +
            "FROM User u " + // Пробел после 'u'
            "INNER JOIN UserRestaraunt ur " +
            "ON u.id = ur.user_id " + // Пробел после 'up.user.id'
            "INNER JOIN Restaraunt r " +
            "ON r.id = ur.restaraunt_id " + // Пробел после 'up.keyword.id'
            "WHERE u.id = :id")
    List<String> showVisitedRestaraunts(@Param("id") Long id);

}

