package com.zzuli;


import com.zzuli.entity.User;
import com.zzuli.mapper.userMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myBatistest {
    @Test
    public void TestInsert() throws IOException {
        //获取核心配置文件的输入流
       InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
       //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper的代理实现类对象
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //调用mapper接口中的方法，实现具体的添加功能
        int result = mapper.insetUser();
      //  result=sqlSession.insert("com.zzuli.mapper.userMapper.insetUser");
        System.out.println("结果"+result);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int result = mapper.updateUser();
        System.out.println("测试结果"+result);
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void test_getUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_getAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void test_getUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.getUsername("admin");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_checkLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = new User(null,"admin","123456",21,'男',"12323@gmail.com");
        int result = mapper.insertUser(user);
        System.out.println(result);
        sqlSession.close();
    }
    @Test
    public void test_checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_getCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }
    @Test
    public void test_getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(4);
        System.out.println(map);
        sqlSession.close();
    }
    @Test
    public void test_getAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
       // List<Map<String, Object>> maps = mapper.getAllUserToMap();

        Map<String, Object> maps = mapper.getAllUserToMap();
     maps.forEach((k,v)-> System.out.println("Item : " + k + " Count : " + v));
      // System.out.println(maps);
        sqlSession.close();
    }
}
