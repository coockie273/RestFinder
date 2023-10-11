package org.example.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRestaraunt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    Long user_id;
    Long restaraunt_id;

    public UserRestaraunt() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRestaraunt(Long id, Long user_id, Long restaraunt_id) {
        this.id = id;
        this.user_id = user_id;
        this.restaraunt_id = restaraunt_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRestaraunt_id() {
        return restaraunt_id;
    }

    public void setRestaraunt_id(Long restaraunt_id) {
        this.restaraunt_id = restaraunt_id;
    }
}
