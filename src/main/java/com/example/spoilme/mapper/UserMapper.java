package com.example.spoilme.mapper;

import com.example.spoilme.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //Mybatis框架 相当于Dao层
public interface UserMapper {

    /*查询全部用户数据*/
    @Select("select * from t_users")
    List<User> getUsers();

    @Select("select * from t_users where u_name=#{uName} and u_password=#{uPassword}")
    User getByUsernameAndPassword(User user);

    /*通过username和password增加一个用户*/
    @Insert("INSERT INTO t_users (u_name, u_password)  VALUES (#{uName},#{uPassword})")
    void addByUsernameAndPassword(User user);

    /*通过username查询用户是否存在*/
    @Select("select * from t_users where u_name=#{uName}")
    User getByUsername(User user);


    @Delete("delete from t_users where u_id = #{uId}")
    void deleteUserById(int id);

    void modifyUser(User user);
}
