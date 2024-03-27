package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.RescueStationMapper;
import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.service.RescueStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RescueStationServiceImpl implements RescueStationService {
    @Autowired
    private RescueStationMapper rescueStationMapper;
    @Override
    public List<RescueStation> getRescueList(Integer id,Integer ownerId) {
        return rescueStationMapper.getRescueStationList(id,ownerId);
    }
    @Override
    public void addRescueStation(RescueStation rescueStation) {
        rescueStationMapper.addRescueStation(rescueStation);
    }

    @Override
    public void deleteRescueStation(RescueStation rescueStation) {
        rescueStationMapper.deleteRescueStation(rescueStation);
    }

    @Override
    public void modifyRescueStation(RescueStation rescueStation) {
        rescueStationMapper.modifyRescueStation(rescueStation);
    }

    @Override
    public void rejectRescueStation(Integer id, String msg) {
        rescueStationMapper.rejectRescueStation( id,  msg);
    }

    @Override
    public void approveRescueStation(Integer id) {
        rescueStationMapper.approveRescueStation( id);
    }

    @Override
    public void reconsiderRescueStation(Integer id, String msg) {
        rescueStationMapper.reconsiderRescueStation( id,  msg);
    }

}
