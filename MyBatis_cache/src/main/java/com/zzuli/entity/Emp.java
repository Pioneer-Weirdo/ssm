package com.zzuli.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {
    private Integer empId;
    private String empName;
    private Integer age;
    private char gender;



    public Emp(Integer empId, String empName, Integer age, char gender) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;

    }



    public Emp() {

    }
}
