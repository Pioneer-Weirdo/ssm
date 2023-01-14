package com.zzuli;

import com.zzuli.entity.Emp;
import com.zzuli.mapper.EmpMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ExampleTest {
    @Test
    public void test_select(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.selectByPrimaryKey(1);
        System.out.println(emp);
        sqlSession.close();
    }
}
