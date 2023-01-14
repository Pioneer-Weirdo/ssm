package com.zzuli.mapper;

import com.zzuli.entity.Dept;
import com.zzuli.entity.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    long countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int deleteByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int insert(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int insertSelective(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    Dept selectByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int updateByExampleSelective(@Param("row") Dept row, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int updateByExample(@Param("row") Dept row, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int updateByPrimaryKeySelective(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Sat Jan 14 14:12:02 CST 2023
     */
    int updateByPrimaryKey(Dept row);
}