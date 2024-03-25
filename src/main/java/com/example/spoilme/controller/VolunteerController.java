package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.Volunteer;
import com.example.spoilme.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.ResultExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    //todo: 申请成为志愿者
    @PostMapping("/v/apply")
    public Result applyForVolunteer(@RequestBody Volunteer volunteer){

        log.info("申请者："+volunteer);
        volunteerService.addVolunteer(volunteer);
        return Result.success("申请成功");
    }
    //获取所有志愿者信息
    @GetMapping("/v/list")
    public Result getVolunteerList(){
        List<Volunteer> list = volunteerService.getVolunteerList();
        return Result.success(list);
    }
    @PostMapping("/v/modify")
    public Result modifyVolunteer(@RequestBody Volunteer volunteer){
        log.info("修改志愿者信息"+volunteer);
        volunteerService.modifyVolunteer(volunteer);
        return Result.success("修改成功");
    }
    @PostMapping("/v/delete")
    public Result deleteVolunteer(@RequestBody Volunteer volunteer){
        log.info("删除志愿者"+volunteer);
        volunteerService.deleteVolunteer(volunteer);
        return Result.success("删除");
    }
}
