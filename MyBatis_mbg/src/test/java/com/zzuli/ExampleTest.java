package com.zzuli;

import com.zzuli.entity.Emp;
import com.zzuli.entity.EmpExample;
import com.zzuli.mapper.EmpMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ExampleTest {
    @Test
    public void test_select(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.selectByPrimaryKey(1);
        System.out.println(emp);
        sqlSession.close();
    }
    @Test
    public void test_selectByExample(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample emp=new EmpExample();
        /**
         * QBC代码风格
         */
        emp.createCriteria().andGenderEqualTo("男").andAgeEqualTo(21);
        List<Emp> emps=mapper.selectByExample(emp);
        emps.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void test_update(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(1,"潘小雯",22,"女",null);
        //int result=mapper.updateByPrimaryKey(emp);
        //选择性修改，字段设置为空时不会修改字段默认值
        int result=mapper.updateByPrimaryKeySelective(emp);
        System.out.println(result);
        sqlSession.close();
    }
    @Test
    public void test_updateByExample(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(1,"潘小雯",22,"女",null);
        int result=mapper.updateByPrimaryKey(emp);
        System.out.println(result);
        sqlSession.close();
    }
}
