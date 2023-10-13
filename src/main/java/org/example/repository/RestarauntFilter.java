package org.example.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RestarauntFilter {
    @Id
    Long r_id;
    String r_name;

    int x;

    int y;

    String k_name;

    String kt_name;

    public RestarauntFilter(Long r_id, String r_name, int x, int y, String k_name, String kt_name) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.x = x;
        this.y = y;
        this.k_name = k_name;
        this.kt_name = kt_name;
    }

    public Long getR_id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }

    public String getKt_name() {
        return kt_name;
    }

    public void setKt_name(String kt_name) {
        this.kt_name = kt_name;
    }
}
