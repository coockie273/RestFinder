package org.example.server.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    public User(){}

    public User(Long id, String first_name, String second_name, String login, String password, int coordinates_x, int coordinates_y) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.login = login;
        this.password = password;
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
    }

    private String first_name;

    private String second_name;

    private String login;

    private String password;

    private int coordinates_x;

    private int coordinates_y;

    public void setCoordinates_x(int coordinates_x) {
        this.coordinates_x = coordinates_x;
    }

    public int getCoordinates_x() {
        return coordinates_x;
    }

    public int getCoordinates_y() {
        return coordinates_y;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}