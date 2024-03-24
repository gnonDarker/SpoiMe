package com.example.spoilme.mapper;

import com.example.spoilme.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //Mybatis框架 相当于Dao层
public interface UserMapper {

    /*查询全部用户数据*/
    @Select("select * from t_users")
    List<User> getUsers();

    @Select("select * from t_users where nickname=#{uName} and password=#{uPassword}")
    User getByUsernameAndPassword(User user);

    /*通过username和password增加一个用户*/
    @Insert("INSERT INTO t_users (nickname, password)  VALUES (#{uName},#{uPassword})")
    void addByUsernameAndPassword(User user);

    /*通过username查询用户是否存在*/
    @Select("select * from t_users where nickname=#{nickname}")
    User getByUsername(User user);


    @Delete("delete from t_users where id = #{uId}")
    void deleteUserById(int id);

    void modifyUser(User user);
}
