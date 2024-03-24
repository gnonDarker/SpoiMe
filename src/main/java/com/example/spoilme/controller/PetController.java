package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class PetController {
    @Autowired
    private PetService petService;

    //todo 增加一个宠物

}
