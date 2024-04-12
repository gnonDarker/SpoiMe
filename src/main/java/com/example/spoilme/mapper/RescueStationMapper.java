package com.example.spoilme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spoilme.pojo.RescueStation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RescueStationMapper extends BaseMapper<RescueStation> {

    List<RescueStation> getRescueStationList(Integer id,Integer ownerId);

    void addRescueStation(RescueStation rescueStation);
    @Delete("DELETE FROM t_rescue_station where id=#{id} or station_name=#{stationName}")
    void deleteRescueStation(RescueStation rescueStation);

    void modifyRescueStation(RescueStation rescueStation);

    @Update("update t_rescue_station set reject_reason='',state = 'approved' where id=#{id}")
    void approveRescueStation(Integer id);

    @Update("update t_rescue_station set reject_reason=#{msg}, state = 'rejected' where id=#{id}")
    void rejectRescueStation(Integer id, String msg);
    @Update("update t_rescue_station set reject_reason=#{msg}, state = 'pending' where id=#{id}")
    void reconsiderRescueStation(Integer id, String msg);
}
