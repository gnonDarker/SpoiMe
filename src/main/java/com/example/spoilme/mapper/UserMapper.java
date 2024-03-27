package com.example.spoilme.mapper;

import com.example.spoilme.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //Mybatis框架 相当于Dao层
public interface UserMapper {

    /*查询全部用户数据*/
    List<User> getUsers(Integer id);

    @Select("select * from t_users where nickname=#{nickname} and password=#{password}")
    User getByUsernameAndPassword(User user);

    /*通过username和password增加一个用户*/
    @Insert("INSERT INTO t_users (nickname, password)  VALUES (#{nickname},#{password})")
    void addByUsernameAndPassword(User user);

    /*通过username查询用户是否存在*/
    @Select("select * from t_users where nickname=#{nickname}")
    User getByUsername(User user);


    @Delete("delete from t_users where id = #{id}")
    void deleteUserById(int id);

    void modifyUser(User user);
    @Delete("delete from t_users where nickname = #{nickname}")
    void deleteUserByName(String name);
}
