package org.example.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KeywordUser {

    @Id
    private Long user_id;

    public KeywordUser(){}

    public KeywordUser(Long user_id, Long keyword_id) {
        this.user_id = user_id;
        this.keyword_id = keyword_id;
    }

    @Id
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
