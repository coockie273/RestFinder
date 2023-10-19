package org.example.server.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RestarauntKeyword {
    @Id
    Long restaraunt_id;

    Long keyword_id;

    public RestarauntKeyword() {

    }

    public RestarauntKeyword(Long restaraunt_id, Long keyword_id) {
        this.restaraunt_id = restaraunt_id;
        this.keyword_id = keyword_id;
    }

    public Long getRestaraunt_id() {
        return restaraunt_id;
    }

    public void setRestaraunt_id(Long restaraunt_id) {
        this.restaraunt_id = restaraunt_id;
    }

    public Long getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(Long keyword_id) {
        this.keyword_id = keyword_id;
    }
}
