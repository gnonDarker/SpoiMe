package com.example.spoilme.controller;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DonationController {
    @Autowired
    private DonationService donationService;

    //todo: 捐物资
    @PostMapping("/donate/material")
    public Result donateMaterial(@RequestBody DonationMaterial donationMaterial){

        donationService.donateMaterial(donationMaterial);
        return Result.success("捐物资成功");
    }
    //todo: 捐款
    @PostMapping("/donate/money")
    public Result donateMoney(@RequestBody DonationMoney donationMoney){
        donationService.donateMoney(donationMoney);
        return Result.success("捐款成功");
    }
}
