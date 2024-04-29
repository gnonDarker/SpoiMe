package com.example.spoilme.controller;

import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.RescueStationService;
import com.example.spoilme.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RescueStationController {
    @Autowired
    private RescueStationService rescueStationService;

    @PostMapping("/rescue/list")
    public Result getRescueList(@RequestBody(required = false) Integer id,
                                @RequestBody(required = false) Integer ownerId){
        List<RescueStation> list = rescueStationService.getRescueList(id,ownerId);
        return Result.success(list);
    }
    @PostMapping("/rescue/apply")
    public Result addRescue(@RequestBody RescueStation rescueStation,
                            @RequestHeader String token){
        rescueStation.setOwnerId(JwtUtils.getTokenId(token));
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
    public Result modifyRescue(@RequestBody RescueStation rescueStation,
                               @RequestHeader String token){
        rescueStation.setOwnerId(JwtUtils.getTokenId(token));
        rescueStationService.modifyRescueStation(rescueStation);
        return Result.success("修改成功");
    }
    @PostMapping("/rescue/audit/approve")
    public Result approveRescue(@RequestBody Integer id){
        rescueStationService.approveRescueStation(id);
        return Result.success("审核通过");
    }
    @PostMapping("/rescue/audit/reject")
    public Result rejectRescue(@RequestBody Integer id, @RequestBody String msg){
        rescueStationService.rejectRescueStation(id,msg);
        return Result.success("审核不通过");
    }
    @PostMapping("/rescue/audit/reconsider")
    public Result reconsiderRescue(@RequestBody Integer id, @RequestBody String msg){
        rescueStationService.reconsiderRescueStation(id,msg);
        return Result.success("已发起申诉");
    }
}
