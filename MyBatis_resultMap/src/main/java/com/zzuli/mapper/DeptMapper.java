package com.zzuli.mapper;

import com.zzuli.entity.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询获取员工信息及对应的部门第二步
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByEmpStepTwo(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpById(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工采用分步查询的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
}
