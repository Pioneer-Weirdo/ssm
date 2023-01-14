package com.zzuli.mapper;

import com.zzuli.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    /**
     * 模糊查询返回list
     * @param vague
     * @return
     */
    List<User> getUserByLike(@Param("vague") String vague);
    int deleteMoreUser(@Param("ids")String ids);

    /**
     * 动态设置表名查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);
    void insertUser(User user);
}
