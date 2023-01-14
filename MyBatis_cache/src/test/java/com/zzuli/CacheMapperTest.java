package com.zzuli;

import com.zzuli.entity.Emp;
import com.zzuli.mapper.CacheMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void test_getEmpById(){
        /**
         * mybatis的一级缓存是sqlSession级别的，
         * 也就是同一个SqlSession查询相同的数据时从缓存中查询，不用执行sql语句
         * sqlSession失效的四种情况：
         * 1)不同sqlSession对应不同的一级缓存
         * 2)同一sqlSession查询条件不同
         * 3)同一sqlSession两次查询期间执行增删改操作
         * 4)同一sqlSession手动清空了缓存
         */
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.clearCache();//手动清空缓存

        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);

        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);
        sqlSession1.close();
        sqlSession2.close();

    }
    @Test
    public void test_Cache() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();

    }

}
