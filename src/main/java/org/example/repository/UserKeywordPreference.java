package org.example.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserKeywordPreference {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long user_id;

    public UserKeywordPreference(){}

    public UserKeywordPreference(Long id, Long user_id, Long keyword_id) {
        this.id = id;
        this.user_id = user_id;
        this.keyword_id = keyword_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long keyword_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(Long keyword_id) {
        this.keyword_id = keyword_id;
    }
}
