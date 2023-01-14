package com.zzuli.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;


    private String username;
    private  String password;
    private  int age;
    private char gender;
    private String email;
    public User(Integer id, String username, String password, int age, char gender, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
}
