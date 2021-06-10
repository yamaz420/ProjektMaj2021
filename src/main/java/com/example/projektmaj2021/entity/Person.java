package com.example.projektmaj2021.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

    private String firstName;
    private String lastname;
    private String email;
    private String address;

    public Person(){
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
