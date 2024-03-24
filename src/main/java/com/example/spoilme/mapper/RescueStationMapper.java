package com.example.spoilme.mapper;

import com.example.spoilme.pojo.RescueStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface RescueStationMapper {

    @Select("select * from t_rescue_station")
    ArrayList<RescueStation> getRescueStationList();
}
