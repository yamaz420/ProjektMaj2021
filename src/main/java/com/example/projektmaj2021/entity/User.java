package com.example.projektmaj2021.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// lägg till här: @Table(name = "users")
public class User extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String salt;
    private String img;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String description) {
        this.username = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", description='" + username + '\'' +
                '}';
    }
}
