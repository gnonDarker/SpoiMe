package com.example.spoilme.service;

import com.example.spoilme.pojo.RescueStation;

import java.util.List;

public interface RescueStationService {
    List<RescueStation> getRescueList();

    void addRescueStation(RescueStation rescueStation);

    void deleteRescueStation(RescueStation rescueStation);

    void modifyRescueStation(RescueStation rescueStation);
}
