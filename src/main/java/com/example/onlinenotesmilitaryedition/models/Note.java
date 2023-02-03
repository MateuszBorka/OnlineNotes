package com.example.onlinenotesmilitaryedition.models;

import jakarta.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "userId")
    private long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
