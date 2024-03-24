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
    public List<Volunteer> getVolunteerList() {
        return volunteerMapper.getVolunteerList();
    }
}
