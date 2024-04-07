package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.Volunteer;
import com.example.spoilme.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/v/apply")
    public Result applyForVolunteer(@RequestBody Volunteer volunteer){

        log.info("申请者："+volunteer);
        volunteerService.addVolunteer(volunteer);
        return Result.success("申请成功");
    }
    //获取所有志愿者信息
    @PostMapping("/v/list")
    public Result getVolunteer(@RequestBody Volunteer volunteer){
        List<Volunteer> list = volunteerService.getVolunteer(volunteer);
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
    @PostMapping("/v/audit/approve")
    public Result approveVolunteer(@RequestBody Integer id){
        volunteerService.approveVolunteer(id);
        return Result.success("审核通过");
    }
    @PostMapping("/v/audit/reject")
    public Result rejectVolunteer(@RequestBody Integer id, @RequestBody String msg){
        volunteerService.rejectVolunteer(id,msg);
        return Result.success("审核不通过");
    }
    @PostMapping("/v/audit/reconsider")
    public Result reconsiderVolunteer(@RequestBody Integer id, @RequestBody String msg){
        volunteerService.reconsiderVolunteer(id,msg);
        return Result.success("已发起申诉");
    }
}
