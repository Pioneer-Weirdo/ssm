package com.zzuli.mapper;

import com.zzuli.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 通过条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**使用choose查询员工信息
     *
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     * @return
     */
    int insertMoreEmp(@Param("emps") List<Emp> emps);

    /**
     * 根据员工id数组批量删除
     * @param empIds
     * @return
     */
    int deleteMoreEmp(@Param("empIds") Integer[] empIds);

}
