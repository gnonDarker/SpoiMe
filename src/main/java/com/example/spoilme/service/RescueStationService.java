package com.example.spoilme.service;

import com.example.spoilme.pojo.RescueStation;

import java.util.List;

public interface RescueStationService {
    List<RescueStation> getRescueList(Integer id,Integer ownerId);
    void addRescueStation(RescueStation rescueStation);

    void deleteRescueStation(RescueStation rescueStation);

    void modifyRescueStation(RescueStation rescueStation);


    void rejectRescueStation(Integer id, String msg);

    void approveRescueStation(Integer id);

    void reconsiderRescueStation(Integer id, String msg);

    boolean hasRescueStation(Integer id);

    RescueStation getRescueStation(Integer id);
}
