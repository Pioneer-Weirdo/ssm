package com.zzuli;

import com.zzuli.entity.Emp;
import com.zzuli.mapper.DynamicSQLMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void test_getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //java中char类型为空的值是'\0'
        Emp emp = new Emp(null,"",null,'男');
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        empByCondition.forEach(System.out::println);
        sqlSession.close();


    }
    @Test
    public void test_getEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //java中char类型为空的值是'\0'
        Emp emp = new Emp(null,"",21,'男');
        List<Emp> empByCondition = mapper.getEmpByChoose(emp);
        empByCondition.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void test_insertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //java中char类型为空的值是'\0'
        Emp emp1 = new Emp(null,"李大胖",21,'男');
        Emp emp2 = new Emp(null,"王小花",21,'女');
        Emp emp3 = new Emp(null,"张小凡",21,'男');
        Emp emp4 = new Emp(null,"潘小雯",21,'女');
        List<Emp> emps = Arrays.asList(emp1,emp2,emp3,emp4);
        int result = mapper.insertMoreEmp(emps);
        System.out.println(result);
        sqlSession.close();
    }
    @Test
    public void test_deleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds= new Integer[]{203301,203302,203303,203304};
        int result = mapper.deleteMoreEmp(empIds);
        System.out.println(result);
        sqlSession.close();
    }
}
