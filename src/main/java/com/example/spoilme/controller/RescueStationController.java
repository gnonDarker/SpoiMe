package com.example.spoilme.controller;

import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.RescueStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RescueStationController {
    @Autowired
    private RescueStationService rescueStationService;

    @GetMapping("/rescue/list")
    public Result getRescueList(){
        List<RescueStation> list = rescueStationService.getRescueList();
        return Result.success(list);
    }
    @PostMapping("/rescue/apply")
    public Result addRescue(@RequestBody RescueStation rescueStation){
        log.info("申请救助站"+rescueStation);
        rescueStationService.addRescueStation(rescueStation);
        return Result.success("申请成功");
    }
    @PostMapping("/rescue/delete")
    public Result deleteRescue(@RequestBody RescueStation rescueStation){
        rescueStationService.deleteRescueStation(rescueStation);
        return Result.success("删除成功");
    }
    @PostMapping("/rescue/modify")
    public Result modifyRescue(@RequestBody RescueStation rescueStation){
        rescueStationService.modifyRescueStation(rescueStation);
        return Result.success("修改成功");
    }
    @PostMapping("rescue/audit")
    public Result auditRescue(@RequestBody RescueStation rescueStation){
        rescueStationService.modifyRescueStation(rescueStation);
        return Result.success("审核成功");
    }
}
