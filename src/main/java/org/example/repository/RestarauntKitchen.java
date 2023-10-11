package org.example.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestarauntKitchen {
    @Id
    Long restaraunt_id;

    Long kitchen_id;

    public RestarauntKitchen() {

    }

    public RestarauntKitchen(Long restaraunt_id, Long kitchen_id) {
        this.restaraunt_id = restaraunt_id;
        this.kitchen_id = kitchen_id;
    }

    public Long getRestaraunt_id() {
        return restaraunt_id;
    }

    public void setRestaraunt_id(Long restaraunt_id) {
        this.restaraunt_id = restaraunt_id;
    }

    public Long getKitchen_id() {
        return kitchen_id;
    }

    public void setKitchen_id(Long kitchen_id) {
        this.kitchen_id = kitchen_id;
    }
}
