package com.example.spoilme.mapper;

import com.example.spoilme.pojo.Volunteer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VolunteerMapper {

    @Insert("insert into t_volunteers(v_user_id, v_name, v_sex, v_phone, v_wechat, v_spare_time, v_experience, v_nick_name, v_age, v_address, v_skill) VALUE " +
            "((#{vUserId}),(#vName),(#vSex),(#vPhone),(#vWechat),(#vSpareTime),(#vExperience),(#vNickName),(#vAge),(#vAddress),(#vSkill))")
    void addVolunteer(Volunteer volunteer);
}
