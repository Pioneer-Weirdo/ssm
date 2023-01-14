package com.zzuli.mapper;

import com.zzuli.entity.Dept;
import com.zzuli.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> getEmp();
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 获取员工以及部门的信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId")Integer empId);

    /***
     * 通过分步查询获取员工信息及对应的部门第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpStepOne(@Param("empId")Integer empId);

    /**
     * 查询部门以及部门中的员工采用分步查询的第二步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);

}
