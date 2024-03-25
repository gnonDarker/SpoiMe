package com.example.spoilme.mapper;

import com.example.spoilme.pojo.RescueStation;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface RescueStationMapper {

    @Select("select * from t_rescue_station")
    ArrayList<RescueStation> getRescueStationList();

    @Insert("INSERT INTO t_rescue_station(owner_id, name,address, phone,qrcode) VALUE (" +
            "#{ownerId}, #{name},#{address}, #{phone},#{qrcode})")
    void addRescueStation(RescueStation rescueStation);
    @Delete("DELETE FROM t_rescue_station where id=#{id} or name=#{name}")
    void deleteRescueStation(RescueStation rescueStation);

    void modifyRescueStation(RescueStation rescueStation);
}
