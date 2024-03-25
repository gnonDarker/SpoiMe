package com.example.spoilme.service;

import com.example.spoilme.pojo.Volunteer;

import java.util.List;

public interface VolunteerService {
    void addVolunteer(Volunteer volunteer);

    List<Volunteer> getVolunteerList();

    void modifyVolunteer(Volunteer volunteer);

    void deleteVolunteer(Volunteer volunteer);
}
