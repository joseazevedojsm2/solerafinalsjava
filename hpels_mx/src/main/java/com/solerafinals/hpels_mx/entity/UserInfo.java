package com.solerafinals.hpels_mx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;
    private Long phone_number;
    private String email;

    public UserInfo() {
    }

    public UserInfo(String first_name, String last_name, Long phone_number, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public UserInfo(Integer id, String first_name, String last_name, Long phone_number, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public UserInfo(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                '}';
    }
}
