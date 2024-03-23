package com.example.spoilme.controller;

import com.example.spoilme.pojo.RescueStation;
import com.example.spoilme.service.RescueStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class RescueStationController {
    @Autowired
    private RescueStationService rescueStationService;
}
