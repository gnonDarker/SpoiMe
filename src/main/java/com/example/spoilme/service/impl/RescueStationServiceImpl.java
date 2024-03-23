package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.RescueStationMapper;
import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.service.RescueStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RescueStationServiceImpl implements RescueStationService {
    @Autowired
    private RescueStationMapper rescueStationMapper;
    @Override
    public ArrayList<RescueStation> getRescueList() {
        return rescueStationMapper.getRescueStationList();
    }
}
