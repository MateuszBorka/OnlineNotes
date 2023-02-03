package com.example.onlinenotesmilitaryedition.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
