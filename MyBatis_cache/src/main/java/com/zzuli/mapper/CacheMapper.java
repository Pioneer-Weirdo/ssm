package com.zzuli.mapper;

import com.zzuli.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     * 根据员工ID查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);
}
