package com.example.spoilme.controller;

import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.RescueStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@ResponseBody
@Slf4j
public class RescueStationController {
    @Autowired
    private RescueStationService rescueStationService;

    @GetMapping("/rescue/getlist")
    public Result getRescueList(){
        ArrayList<RescueStation> list = rescueStationService.getRescueList();
        return Result.success(list);
    }
}
