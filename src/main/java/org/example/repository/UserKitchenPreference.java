package org.example.repository;

import jakarta.persistence.*;

@Entity
public class UserKitchenPreference {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long user_id;

    public UserKitchenPreference(Long id, Long user_id, Long kitchen_id) {
        this.id = id;
        this.user_id = user_id;
        this.kitchen_id = kitchen_id;
    }

    public UserKitchenPreference(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKitchen_id() {
        return kitchen_id;
    }

    public void setKitchen_id(Long kitchen_id) {
        this.kitchen_id = kitchen_id;
    }

    private Long kitchen_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getKeyword_id() {
        return kitchen_id;
    }

    public void setKeyword_id(Long keyword_id) {
        this.kitchen_id = keyword_id;
    }
}
