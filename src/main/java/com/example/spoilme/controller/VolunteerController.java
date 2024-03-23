package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.Volunteer;
import com.example.spoilme.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.ResultExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    //todo: 申请成为志愿者
    @PostMapping("/v/apply")
    public Result applyForVolunteer(Volunteer volunteer){

        log.info("申请者："+volunteer);

        volunteerService.addVolunteer(volunteer);

        return Result.success("申请成功");
    }
}
