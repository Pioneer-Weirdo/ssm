package com.zzuli;

import com.zzuli.entity.Dept;
import com.zzuli.entity.Emp;
import com.zzuli.mapper.DeptMapper;
import com.zzuli.mapper.EmpMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void test_getEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
        sqlSession.close();
    }
    @Test
    public void test_getEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(1009);
        System.out.println(emp);
        sqlSession.close();
    }
    @Test
    public void test_getEmpAndDeptByEmpStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpStepOne(1009);
        System.out.println(emp.getEmpName());
        sqlSession.close();
    }
    @Test
    public void test_getDeptAndEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpById(1);
        List<Emp> empList = dept.getEmpList();
        //System.out.println(dept);
        empList.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void test_getDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        List<Emp> empList = dept.getEmpList();
        //System.out.println(dept);
        empList.forEach(System.out::println);
        sqlSession.close();
    }


}
