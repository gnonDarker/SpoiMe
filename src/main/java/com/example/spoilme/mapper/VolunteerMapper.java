package com.example.spoilme.mapper;

import com.example.spoilme.pojo.Volunteer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VolunteerMapper {

    @Insert("insert into t_volunteers(user_id, name, sex, phone, wechat, spare_time, experience, nickname, age, address, skill) VALUE " +
            "(#{userId},#{name},#{sex},#{phone},#{wechat},#{spareTime},#{experience},#{nickname},#{age},#{address},#{skill})")
    void addVolunteer(Volunteer volunteer);

    @Select("select * from t_volunteers")
    List<Volunteer> getVolunteerList();

    void modifyVolunteer(Volunteer volunteer);

    @Delete("DELETE from t_volunteers where id=#{id} or nickname = #{nickname} or name = #{name}")
    void deleteVolunteer(Volunteer volunteer);
}
