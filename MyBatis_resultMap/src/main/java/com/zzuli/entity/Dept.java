package com.zzuli.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private  Integer deptId;
    private  String deptName;
    private List<Emp> empList;
}
