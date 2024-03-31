package com.example.spoilme.controller;

import com.example.spoilme.service.AdoptionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdoptionController {

    @Resource
    AdoptionService adoptionService;


}
