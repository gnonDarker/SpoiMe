package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.VolunteerMapper;
import com.example.spoilme.pojo.Volunteer;
import com.example.spoilme.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerMapper volunteerMapper;
    @Override
    public void addVolunteer(Volunteer volunteer) {
        volunteerMapper.addVolunteer(volunteer);
    }

    @Override
    public List<Volunteer> getVolunteerList(Integer id) {
        return volunteerMapper.getVolunteerList(id);
    }

    @Override
    public void modifyVolunteer(Volunteer volunteer) {
        volunteerMapper.modifyVolunteer(volunteer);
    }

    @Override
    public void deleteVolunteer(Volunteer volunteer) {
        volunteerMapper.deleteVolunteer(volunteer);
    }

    @Override
    public void rejectVolunteer(Integer id, String msg) {
        volunteerMapper.rejectVolunteer( id,  msg);
    }

    @Override
    public void approveVolunteer(Integer id) {
        volunteerMapper.approveVolunteer( id);
    }

    @Override
    public void reconsiderVolunteer(Integer id, String msg) {
        volunteerMapper.reconsiderVolunteer( id,  msg);
    }
}
