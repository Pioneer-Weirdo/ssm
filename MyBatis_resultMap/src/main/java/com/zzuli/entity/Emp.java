package com.zzuli.entity;

import lombok.Data;

@Data
public class Emp {
    private Integer empId;
    private String empName;
    private Integer age;
    private char gender;
    private  Dept dept;


    public Emp(Integer empId, String empName, Integer age, char gender,Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.dept=dept;
    }



    public Emp() {

    }
}
