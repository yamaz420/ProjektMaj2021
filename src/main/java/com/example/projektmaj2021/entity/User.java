package com.example.projektmaj2021.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String salt;
    private String img;
    //@Column(name="username")
    public User() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }

    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }


 /**   @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", description='" + username + '\'' +
                '}';
    }*/
}
