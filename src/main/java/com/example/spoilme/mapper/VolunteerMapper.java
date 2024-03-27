package com.example.spoilme.mapper;

import com.example.spoilme.pojo.Volunteer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VolunteerMapper {

    @Insert("insert into t_volunteers(user_id, name, sex, phone, wechat, spare_time, experience, nickname, age, address, skill) VALUE " +
            "(#{userId},#{name},#{sex},#{phone},#{wechat},#{spareTime},#{experience},#{nickname},#{age},#{address},#{skill})")
    void addVolunteer(Volunteer volunteer);

    @Select("select * from t_volunteers where id=#{id}")
    List<Volunteer> getVolunteerList(Integer id);

    void modifyVolunteer(Volunteer volunteer);

    @Delete("DELETE from t_volunteers where id=#{id} or nickname = #{nickname} or name = #{name}")
    void deleteVolunteer(Volunteer volunteer);
    @Update("update t_volunteers set reject_reason=#{msg}, state = 'rejected' where id=#{id}")
    void rejectVolunteer(Integer id, String msg);
    @Update("update t_volunteers set reject_reason='',state = 'approved' where id=#{id}")
    void approveVolunteer(Integer id);
    @Update("update t_volunteers set reject_reason=#{msg}, state = 'pending' where id=#{id}")
    void reconsiderVolunteer(Integer id, String msg);
}
