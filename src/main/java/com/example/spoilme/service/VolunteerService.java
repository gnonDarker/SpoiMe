package com.example.spoilme.service;

import com.example.spoilme.pojo.Volunteer;

import java.util.List;

public interface VolunteerService {
    void addVolunteer(Volunteer volunteer);

    List<Volunteer> getVolunteer(Volunteer volunteer);

    void modifyVolunteer(Volunteer volunteer);

    void deleteVolunteer(Volunteer volunteer);

    void rejectVolunteer(Integer id, String msg);

    void approveVolunteer(Integer id);

    void reconsiderVolunteer(Integer id, String msg);
}
