package com.zzuli;

import com.mysql.cj.jdbc.Driver;
import com.zzuli.entity.User;
import com.zzuli.mapper.SpecialSQLMapper;
import com.zzuli.mapper.userMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class SpecialSQLMapperTest {
    @Test
    public void test_getUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        // List<Map<String, Object>> maps = mapper.getAllUserToMap();
        List<User> users = mapper.getUserByLike("a");
        users.forEach(System.out::println);


        // System.out.println(maps);
        sqlSession.close();
    }
    @Test
    public void test_deleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        // List<Map<String, Object>> maps = mapper.getAllUserToMap();
        int result = mapper.deleteMoreUser("4,8");
        System.out.println("结果为"+result);

        sqlSession.close();

    }
    @Test
    public void test_getUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> user = mapper.getUserList("t_user");
        user.forEach(System.out::println);
        sqlSession.close();

    }

    /**
     * JDBC封装了自动获取自增主键的方法
     */
    @Test
    public void testJDBC(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC","root","123456");
            String sql="insert into t_user values(null,'admin','123456',21,'男','12323@gmail.com')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            System.out.println(resultSet.getInt(1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void test_insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"admin","123456",21,'男',"12323@gmail.com");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
}
