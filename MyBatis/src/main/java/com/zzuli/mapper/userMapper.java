package com.zzuli.mapper;

import com.zzuli.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface userMapper {
    int insetUser();
    int updateUser();
    int deleteUser();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUsername(String username);
    User getUserById();
    List<User> getAllUser();
    User checkLogin(String username,String password);

    /**
     * 登录验证（以map集合坐为参数）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);
    User checkLoginByParam(@Param("username")String username, @Param("password")String password);
    int insertUser(User user);
    int getCount();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") int id);

    /**
     *查询所有用户信息为map集合
     * 解决方法一：用一个list存放返回的map
     * 解决方法二：使用注解将返回的map的id作为map的关键字
     * @return
     */
   // List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
